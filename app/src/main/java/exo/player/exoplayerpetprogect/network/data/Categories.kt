package exo.player.exoplayerpetprogect.network.data

import com.google.gson.annotations.SerializedName

data class Categories(
     @SerializedName("name") var name: String? = null,
     @SerializedName("videos") var videos: ArrayList<Videos> = arrayListOf(),
)
