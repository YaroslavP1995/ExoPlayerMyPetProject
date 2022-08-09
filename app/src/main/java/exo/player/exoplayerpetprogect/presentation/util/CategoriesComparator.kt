package exo.player.exoplayerpetprogect.presentation.util

import androidx.recyclerview.widget.DiffUtil
import exo.player.exoplayerpetprogect.network.data.Videos

class CategoriesComparator : DiffUtil.ItemCallback<Videos>() {
    override fun areItemsTheSame(oldItem: Videos, newItem: Videos): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Videos, newItem: Videos): Boolean {
        return oldItem == newItem
    }
}