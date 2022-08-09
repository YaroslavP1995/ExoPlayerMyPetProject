package payments.oline.application.domain.usecases

import exo.player.exoplayerpetprogect.network.api.VideoInfoApi
import exo.player.exoplayerpetprogect.network.data.VideoInfoData
import payments.oline.application.domain.usecasesImpl.GetVideosInfoUseCase
import javax.inject.Inject

class GetVideosInfoUseCaseNetwork @Inject constructor(
    private val api: VideoInfoApi,
) : GetVideosInfoUseCase {

    override suspend fun getAllVideo(): VideoInfoData? {
        return api.getAllVideo().body()
    }
}

