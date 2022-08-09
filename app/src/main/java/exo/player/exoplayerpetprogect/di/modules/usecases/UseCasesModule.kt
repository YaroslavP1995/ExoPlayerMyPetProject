package payments.oline.application.di.modules.usecases

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import payments.oline.application.domain.usecases.GetVideosInfoUseCaseNetwork
import payments.oline.application.domain.usecasesImpl.GetVideosInfoUseCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface UseCasesModule {

    @Binds
    @Singleton
    fun bindRegisterUserUseCase(useCase: GetVideosInfoUseCaseNetwork): GetVideosInfoUseCase
}