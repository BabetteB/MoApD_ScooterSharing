package dk.itu.moapd.scootersharing.babb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dk.itu.moapd.scootersharing.babb.databinding.FragmentStartRideBinding

class StartRideFragment : Fragment() {

    private var _binding : FragmentStartRideBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Oh no I died"
        }

    private lateinit var scooter: Scooter

    companion object{
        private val TAG = StartRideFragment::class.qualifiedName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scooter = Scooter(
            name = "",
            location = ""
        )

        Log.d(TAG, "fragment created")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartRideBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonStartRide.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Scooter created",
                    Toast.LENGTH_SHORT
                ).show()
                //findNavController().popBackStack(scooter)
            }

            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }



}