package guuilp.github.com.character.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import guuilp.github.com.character.databinding.FragmentCharacterListBinding
import guuilp.github.com.character.di.injectFeature
import guuilp.github.com.character.list.presentation.CharacterListModel
import guuilp.github.com.character.list.presentation.CharacterListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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
            characterList.adapter = CharacterListAdapter(characterListViewModel)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterListViewModel.model.action.observe(viewLifecycleOwner) { action ->
            if (action is CharacterListModel.Action.ItemClick) {
                val navAction =
                    CharacterListFragmentDirections.actionCharacterlistToCharacterdetail(action.characterId)
                findNavController().navigate(navAction)
            }
        }
    }
}
