package com.ny.times.data.room.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This is a sample from article entity which will be updated after that
 */
@Entity(tableName = "article")
data class ArticleEntity (
    @PrimaryKey
    @NonNull
    var id:Int,

    var title : String,

    var source : String,

    var byline : String,

    var date : String

) : BaseEntity()