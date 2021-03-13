package com.ny.times.ui.fragments.details

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ny.times.ui.fragments.base.BaseFragment
import com.ny.times.R.layout.fragment_article_detail
import com.ny.times.data.ws.model.mostviewed.ResultModel
import com.ny.times.ui.adapters.MediaRecyclerAdapter
import com.ny.times.ui.fragments.articles.ArticleDetailsViewModel
import kotlinx.android.synthetic.main.fragment_article_detail.view.*
import kotlinx.android.synthetic.main.item_article.view.date_txt
import kotlinx.android.synthetic.main.item_article.view.section_txt
import kotlinx.android.synthetic.main.item_article.view.title_txt

class ArticleDetailsFragment : BaseFragment() {

    companion object {
        const val ARTICLE_KEY = "article"

        fun newInstance() = ArticleDetailsFragment()
    }

    init {
        layout = fragment_article_detail
    }

    private var article : ResultModel? = null
    private lateinit var viewModel: ArticleDetailsViewModel

    override fun initViews() {
        article?.let { article ->
            article.title?.let {
                rootView.title_txt.text = it
            }
            article.published_date?.let {
                rootView.date_txt.text = it
            }
            article.section?.let {
                rootView.section_txt.text = it
            }
            article.adx_keywords?.let {
                rootView.keywords_txt.text = it
            }
            article.byline?.let {
                rootView.byline_txt.text = it
            }
            article.abstractValue?.let {
                rootView.abstract_txt.text = it
            }
            article.media?.let {
                rootView.media_recycler.adapter = MediaRecyclerAdapter(it,activity)
            }
        }
    }

    override fun doCreate() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackEnabled(true)
        viewModel = ViewModelProvider(this).get(ArticleDetailsViewModel::class.java)
        activity?.let {
            viewModel.init(it)
        }
        arguments?.let { args ->
            article = args[ARTICLE_KEY] as ResultModel
            article?.let { article ->
                article.byline?.let {
                    setTitle(it)
                }
            }
        }
    }

}
