package guuilp.github.com.character.common

import androidx.recyclerview.widget.DiffUtil

class HashItemCallback<T : StableItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.hashCode() == newItem.hashCode()
}