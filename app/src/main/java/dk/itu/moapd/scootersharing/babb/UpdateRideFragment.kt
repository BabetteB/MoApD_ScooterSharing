package dk.itu.moapd.scootersharing.babb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dk.itu.moapd.scootersharing.babb.databinding.FragmentUpdateRideBinding

class UpdateRideFragment : Fragment() {

    private var _binding : FragmentUpdateRideBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Oh no I died"
        }

    private lateinit var scooter : Scooter
    private val args : UpdateRideFragmentArgs by navArgs()

    companion object{
        private val TAG = UpdateRideFragment::class.qualifiedName

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scooter = Scooter(
            name = "",
            location = ""
        )

        Log.d(TAG, "The scooter name is ${args.rideName}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateRideBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            informationInput.nameInput.apply {
                setText(args.rideName)
                isEnabled = false
            }

            buttonUpdateRide.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Location updated",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

}