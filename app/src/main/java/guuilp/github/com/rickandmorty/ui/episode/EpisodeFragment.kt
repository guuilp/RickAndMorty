package guuilp.github.com.rickandmorty.ui.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import guuilp.github.com.rickandmorty.R

class EpisodeFragment : Fragment() {

    private lateinit var episodeViewModel: EpisodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        episodeViewModel =
            ViewModelProviders.of(this).get(EpisodeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        episodeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}