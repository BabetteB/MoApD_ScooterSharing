package dk.itu.moapd.scootersharing.babb.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dk.itu.moapd.scootersharing.babb.databinding.FragmentMainBinding

/**
 * The main fragment containing sub-fragments
 */
class MainFragment : Fragment() {

    /**
     * The view binding for the Main fragment - can be null'ed upon destruction
     */
    private var _binding : FragmentMainBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Oh no I died"
        }

    /**
     * upon creating the view for the main fragment, set and inflate the binding (see fragment_main.xml)
     * @return View that holds the fragment container
     * @property inflater, the inflater we pass to the onCreateView - Here, a LayoutInflater
     * @property container, the ViewGroup passed to onCreateView, used to contain other Views.
     * @property savedInstanceState, a mapping of saved components in a Bundle.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}