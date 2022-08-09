package exo.player.exoplayerpetprogect.network.api

import exo.player.exoplayerpetprogect.network.data.VideoInfoData
import retrofit2.Response
import retrofit2.http.GET

interface VideoInfoApi {

    @GET("3decc66cc18f97acb97b0bd87f52a0ed/raw/7aa58e2db03bdae759e9b69c0b991b865ad7e91a/list_videos_info")
    suspend fun getAllVideo(): Response<VideoInfoData>
}

