package guuilp.github.com.location.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import guuilp.github.com.location.R
import guuilp.github.com.location.presentation.LocationViewModel

class LocationFragment : Fragment() {

    private lateinit var locationViewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_location, container, false)
}