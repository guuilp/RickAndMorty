package guuilp.github.com.character.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import guuilp.github.com.character.common.HashItemCallback
import guuilp.github.com.character.databinding.CharacterListItemBinding
import guuilp.github.com.character.model.CharacterListItemView

class CharacterListAdapter : ListAdapter<CharacterListItemView, CharacterListAdapter.ViewHolder>(
    HashItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.character = getItem(position)
    }

    class ViewHolder(val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
