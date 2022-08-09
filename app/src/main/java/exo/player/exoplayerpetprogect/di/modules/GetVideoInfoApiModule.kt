package payments.oline.application.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import exo.player.exoplayerpetprogect.network.ApiModuleProvider
import exo.player.exoplayerpetprogect.network.api.VideoInfoApi
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetVideoInfoApiModule : ApiModuleProvider<VideoInfoApi> {
    @Singleton
    @Provides
    override fun provideApi(retrofit: Retrofit): VideoInfoApi {
        return retrofit.create(VideoInfoApi::class.java)
    }
}
