package com.ny.times.ui.adapters

import android.view.View
import com.ny.times.data.ws.model.mostviewed.ResultModel

interface ArticleClickListener {
    fun onArticleClick(view: View, result: ResultModel)
}