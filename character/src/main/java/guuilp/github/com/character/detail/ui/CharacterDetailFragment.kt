package guuilp.github.com.character.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import guuilp.github.com.character.databinding.FragmentCharacterDetailBinding
import guuilp.github.com.character.di.characterModule
import guuilp.github.com.character.list.ui.CharacterListAdapter
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(characterModule) }
private fun injectFeature() = loadFeature

class CharacterDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCharacterDetailBinding.inflate(inflater, container, false).apply {
            injectFeature()
            lifecycleOwner = viewLifecycleOwner
            episodeList.adapter = CharacterListAdapter()
        }.root
    }
}