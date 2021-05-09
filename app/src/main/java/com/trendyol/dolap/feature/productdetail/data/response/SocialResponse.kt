package com.trendyol.dolap.feature.productdetail.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class SocialResponse(
    @SerializedName("likeCount")
    val likeCount: Int? = null,

    @SerializedName("commentCounts")
    val commentCounts: CommentCounts? = null
) {
}
@Parcelize
data class CommentCounts(
    @SerializedName("averageRating")
    val averageRating: Float? = null,

    @SerializedName("anonymousCommentsCount")
    val anonymousCommentsCount: Int? = null,

    @SerializedName("memberCommentsCount")
    val memberCommentsCount: Int? = null,
): Parcelable