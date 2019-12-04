package guuilp.github.com.character.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import guuilp.github.com.character.databinding.FragmentCharacterDetailBinding
import guuilp.github.com.character.detail.presentation.CharacterDetailViewModel
import guuilp.github.com.character.di.injectFeature
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetailFragment : Fragment() {

    private val characterListViewModel: CharacterDetailViewModel by viewModel { parametersOf(args.characterId) }
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCharacterDetailBinding.inflate(inflater, container, false).apply {
            injectFeature()
            lifecycleOwner = viewLifecycleOwner
            viewModel = characterListViewModel
        }.root
    }
}
