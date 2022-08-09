package exo.player.exoplayerpetprogect.presentation.fragments.listvideos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import exo.player.exoplayerpetprogect.databinding.VideoItemBinding
import exo.player.exoplayerpetprogect.network.data.Videos
import exo.player.exoplayerpetprogect.presentation.util.CategoriesComparator

class ListVideoInfoAdapter (private val onClickItem: (Videos) -> Unit) :
    ListAdapter<Videos, RecyclerView.ViewHolder>(CategoriesComparator()) {
    private var player: ExoPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CountryViewHolder(
            VideoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CountryViewHolder) {
            holder.bind(getItem(position))
        }
    }

    internal inner class CountryViewHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Videos) {
            player = getPlayer(binding.videoPlayer.context)
            with(binding){
                title.text = item.title
                description.text = item.description
                binding.videoPlayer.player = player
                videoPlayer.setOnClickListener {
                    onClickItem.invoke(item)
                }
            }
            playVideo(item.sources[0])
        }
    }

    private fun playVideo(url: String) {
        player?.run {
            addMediaItem(getMediaItem(url))
            prepare()
        }
    }

    fun getPlayer(context: Context): ExoPlayer {
        return ExoPlayer.Builder(context)
            .setMediaSourceFactory(getMediaSource(context))
            .build()
    }

    private fun getMediaItem(url: String): MediaItem {
        return MediaItem.fromUri(url)
    }

    private fun getSourceFactory(context: Context): DataSource.Factory {
        return DefaultDataSource.Factory(context)
    }

    private fun getMediaSource(context: Context): MediaSource.Factory {
        return ProgressiveMediaSource.Factory(getSourceFactory(context))
    }
}