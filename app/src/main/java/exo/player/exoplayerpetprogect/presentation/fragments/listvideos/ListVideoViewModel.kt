package exo.player.exoplayerpetprogect.presentation.fragments.listvideos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import exo.player.exoplayerpetprogect.network.data.VideoInfoData
import kotlinx.coroutines.launch
import payments.oline.application.domain.usecasesImpl.GetVideosInfoUseCase
import payments.oline.application.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ListVideoViewModel @Inject constructor(
    private val getVideosInfoUseCase: GetVideosInfoUseCase
) : BaseViewModel() {

    private val _videoInfoData = MutableLiveData<VideoInfoData?>()
    val videoInfoData: LiveData<VideoInfoData?>
        get() = _videoInfoData

    fun getVideoListInfo() {
        scope.launch {
            _videoInfoData.postValue(getVideosInfoUseCase.getAllVideo())
        }
    }
}