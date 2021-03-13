package com.ny.times.ui.fragments.articles

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.ny.times.data.repo.MostViewedRepository
import com.ny.times.data.ws.model.response.MostViewedArticlesResponse
import com.ny.times.ui.fragments.base.BaseViewModel

class ArticlesListViewModel : BaseViewModel() {

    private var mostViewedArticlesResponse: MostViewedRepository? = null

    override fun init(context: Context) {
        super.init(context)
        mostViewedArticlesResponse = MostViewedRepository(context,this)
    }

    fun getCityWeatherLiveData(section:String, period:Int): MutableLiveData<MostViewedArticlesResponse> {
        if(!showLoading()){
            return MutableLiveData()
        }
        return mostViewedArticlesResponse!!.getMostViewedData(section,period)
    }
}
