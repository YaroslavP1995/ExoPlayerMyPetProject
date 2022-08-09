package exo.player.exoplayerpetprogect.network.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videos(
    @SerializedName("description") var description: String? ,
    @SerializedName("sources") var sources: ArrayList<String> = arrayListOf(),
    @SerializedName("subtitle") var subtitle: String? ,
    @SerializedName("thumb") var thumb: String? ,
    @SerializedName("title") var title: String? ,
) : Parcelable
