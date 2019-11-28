package guuilp.github.com.episode.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import guuilp.github.com.episode.R
import guuilp.github.com.episode.presentation.EpisodeViewModel

class EpisodeFragment : Fragment() {

    private lateinit var episodeViewModel: EpisodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_episode, container, false)
}