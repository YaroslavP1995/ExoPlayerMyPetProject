package exo.player.exoplayerpetprogect.presentation.fragments.listvideos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import exo.player.exoplayerpetprogect.databinding.VideoListFragmentBinding
import exo.player.exoplayerpetprogect.network.data.Videos
import exo.player.exoplayerpetprogect.presentation.fragments.listvideos.adapter.ListVideoInfoAdapter
import payments.oline.application.presentation.base.BaseFragment

@AndroidEntryPoint
class ListVideoFragment : BaseFragment<VideoListFragmentBinding>() {

    private val viewModel: ListVideoViewModel by viewModels()
    private lateinit var communitiesAdapter: ListVideoInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = VideoListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
        initUi()
        setupObserver()
    }

    private fun initUi() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            communitiesAdapter = ListVideoInfoAdapter(onClickVideo())
            listVideoRecycler.adapter = communitiesAdapter
        }
    }

    private fun onClickVideo(): (Videos) -> Unit = {
        findNavController().navigate(
            ListVideoFragmentDirections.actionListVideoFragmentToExoFullscreen(
                it.sources[0]
            )
        )
        Log.d("yarek", "clicked "+it.title)
    }

    private fun requestData() {
        viewModel.getVideoListInfo()
    }

    private fun setupObserver() {
        viewModel.videoInfoData.observe(viewLifecycleOwner) { data ->
            communitiesAdapter.submitList(data?.categories?.get(0)?.videos)
        }
    }

}