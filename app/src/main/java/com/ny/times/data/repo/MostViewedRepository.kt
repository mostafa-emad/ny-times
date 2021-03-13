package com.ny.times.data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import com.ny.times.data.ws.model.response.MostViewedArticlesResponse
import com.ny.times.data.ws.rest.ServiceGenerator
import com.ny.times.data.ws.rest.constants.ApiServicesNames
import com.ny.times.data.ws.rest.listeners.ILoadingListener

class MostViewedRepository (context: Context,private val loadingListener: ILoadingListener) : BaseRepository(context){
    private val mostViewedData : MutableLiveData<MostViewedArticlesResponse> = MutableLiveData()

    fun getMostViewedData(section:String, period:Int) : MutableLiveData<MostViewedArticlesResponse>  {
        val call = ServiceGenerator.clientApi.getMostViewedData(section,period,ApiServicesNames.API_KEY)
        call.enqueue(object : Callback<MostViewedArticlesResponse> {
            override fun onResponse(call: Call<MostViewedArticlesResponse>, response: retrofit2.Response<MostViewedArticlesResponse>) {
                if (response.body() !== null) {
                    (response.body() as MostViewedArticlesResponse).let{
                        mostViewedData.value = it
                    }
                }
                loadingListener.onComplete()
            }

            override fun onFailure(call: Call<MostViewedArticlesResponse>, t: Throwable) {
                loadingListener.onComplete()
                t.printStackTrace()
            }
        })
        return mostViewedData
    }

}