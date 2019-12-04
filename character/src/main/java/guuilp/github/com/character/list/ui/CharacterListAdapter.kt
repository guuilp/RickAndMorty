package guuilp.github.com.character.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import guuilp.github.com.character.common.HashItemCallback
import guuilp.github.com.character.databinding.CharacterListItemBinding
import guuilp.github.com.character.list.model.CharacterListItemView
import guuilp.github.com.character.list.presentation.CharacterListViewModel

class CharacterListAdapter(
    private val characterListViewModel: CharacterListViewModel
) : ListAdapter<CharacterListItemView, CharacterListAdapter.ViewHolder>(
    HashItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            character = getItem(position)
            viewModel = characterListViewModel
        }
    }

    class ViewHolder(val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
