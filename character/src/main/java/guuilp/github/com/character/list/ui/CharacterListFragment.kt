package guuilp.github.com.character.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import guuilp.github.com.character.databinding.FragmentCharacterListBinding
import guuilp.github.com.character.di.characterModule
import guuilp.github.com.character.list.presentation.CharacterListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(characterModule) }
private fun injectFeature() = loadFeature

class CharacterListFragment : Fragment() {

    private val characterListViewModel: CharacterListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCharacterListBinding.inflate(inflater, container, false).apply {
            injectFeature()
            lifecycleOwner = viewLifecycleOwner
            viewModel = characterListViewModel
            characterList.adapter = CharacterListAdapter()
        }.root
    }
}
