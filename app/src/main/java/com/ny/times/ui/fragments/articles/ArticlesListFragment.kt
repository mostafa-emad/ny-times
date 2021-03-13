package com.ny.times.ui.fragments.articles

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ny.times.R
import com.ny.times.data.ws.model.response.MostViewedArticlesResponse
import com.ny.times.ui.adapters.ArticlesRecyclerAdapter
import com.ny.times.ui.fragments.base.BaseFragment
import com.ny.times.R.layout.fragment_articles_list
import com.ny.times.data.ws.model.mostviewed.ResultModel
import com.ny.times.ui.adapters.ArticleClickListener
import com.ny.times.ui.fragments.details.ArticleDetailsFragment
import kotlinx.android.synthetic.main.fragment_articles_list.view.*

class ArticlesListFragment : BaseFragment(),ArticleClickListener {

    //NY Times Sections
    private val allSections = "all-sections"
    private val viewedSection = "viewed"
    private val emailedSection = "emailed"
    private val sharedSection = "shared"

    //NY Times Periods
    private val oneDayPeriod = 1
    private val oneWeekPeriod = 7
    private val oneMonthPeriod = 30

    companion object {
        fun newInstance() = ArticleDetailsFragment()
    }

    init {
        layout = fragment_articles_list
    }

    private val articlesResult : ArrayList<ResultModel> = arrayListOf()
    private lateinit var viewModel: ArticleDetailsViewModel
    private lateinit var articlesRecyclerAdapter: ArticlesRecyclerAdapter

    override fun initViews() {
        setTitle(resources.getString(R.string.app_name))
        val layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.VERTICAL,false)
        rootView.results_recycler?.layoutManager = layoutManager
        articlesRecyclerAdapter = ArticlesRecyclerAdapter(articlesResult, activity,this)
        rootView.results_recycler?.adapter = articlesRecyclerAdapter
    }

    override fun doCreate() {
        rootView.period_spinner?.setSelection(1)
        rootView.period_spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getMostViewedArticles(when(position){
                    0 -> oneDayPeriod
                    1 -> oneWeekPeriod
                    2 -> oneMonthPeriod
                    else -> oneWeekPeriod
                })
            }

        }
    }

    private fun getMostViewedArticles(period:Int = oneWeekPeriod){
        viewModel.getCityWeatherLiveData(allSections,period).observe(this, Observer<MostViewedArticlesResponse> {
            articlesResult.clear()
            it.let {
                articlesResult.addAll(it.results)
                articlesRecyclerAdapter.notifyDataSetChanged()
            }
            if(articlesResult.isNotEmpty()){
                rootView.no_data_available_txt!!.visibility = View.GONE
            }else{
                rootView.no_data_available_txt!!.visibility = View.VISIBLE
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArticleDetailsViewModel::class.java)
        activity?.let {
            viewModel.init(it)
        }
    }

    override fun onArticleClick(view: View, result: ResultModel) {
        val args = Bundle()
        args.putSerializable(ArticleDetailsFragment.ARTICLE_KEY, result)
        getNavController().navigate(R.id.actionOpenArticleDetails,args)
    }

}
