package com.ny.times.data.ws.model.mostviewed

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MediaModel : Serializable{
    var type: String? = null
    var subtype: String? = null
    var caption: String? = null
    var copyright: String? = null
    var approved_for_syndication = 0

    @SerializedName("media-metadata")
    var mediaMetaData: List<MediaMetaData>? =
        null

}