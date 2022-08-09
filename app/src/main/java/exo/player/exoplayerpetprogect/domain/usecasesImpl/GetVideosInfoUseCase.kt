package payments.oline.application.domain.usecasesImpl

import exo.player.exoplayerpetprogect.network.data.VideoInfoData


interface GetVideosInfoUseCase {

    suspend fun getAllVideo(): VideoInfoData?

}