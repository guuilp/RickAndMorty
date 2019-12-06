package guuilp.github.com.character.detail.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import guuilp.github.com.character.databinding.SimpleListItemBinding
import guuilp.github.com.character.detail.presentation.CharacterDetailViewModel

class CharacterDetailEpisodeListAdapter(
    private val characterDetailViewModel: CharacterDetailViewModel
) : ListAdapter<String, CharacterDetailEpisodeListAdapter.ViewHolder>(CharacterEpisodeListDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SimpleListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            episodeTitle = getItem(position)
            viewModel = characterDetailViewModel
        }
    }

    class ViewHolder(val binding: SimpleListItemBinding) : RecyclerView.ViewHolder(binding.root)

    class CharacterEpisodeListDiff : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }
}
