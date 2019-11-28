package guuilp.github.com.character.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import guuilp.github.com.character.R
import guuilp.github.com.character.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment() {

    private val characterViewModel: CharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_character, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterViewModel.characters.observe(viewLifecycleOwner) {
            Toast.makeText(context, it.size.toString(), Toast.LENGTH_LONG).show()
        }
    }
}