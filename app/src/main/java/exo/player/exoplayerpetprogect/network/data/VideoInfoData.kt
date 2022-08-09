package exo.player.exoplayerpetprogect.network.data

import com.google.gson.annotations.SerializedName

data class VideoInfoData(
 @SerializedName("categories") var categories: List<Categories>,
)
