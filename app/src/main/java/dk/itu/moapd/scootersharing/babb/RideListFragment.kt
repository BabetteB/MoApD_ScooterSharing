package dk.itu.moapd.scootersharing.babb

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dk.itu.moapd.scootersharing.babb.databinding.FragmentRideListBinding
import kotlinx.coroutines.launch

private const val TAG = "RideListFragment"

class RideListFragment : Fragment() {

    private var _binding: FragmentRideListBinding? = null
    private val binding
        get() = checkNotNull(_binding){
            "Cannot access binding."
        }

    private val viewModel : ScooterViewModel by lazy {
        ViewModelProvider(this)[ScooterViewModel::class.java]
    }

    companion object {
        lateinit var ridesDB : RidesDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ridesDB = RidesDB.get(this.requireActivity())

        setHasOptionsMenu(true)
        Log.d(TAG, "Got ViewModel for list of scooters: $viewModel")
        Log.d(TAG, "Total rides: ${ridesDB.getRidesList().size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRideListBinding.inflate(inflater, container, false)
        binding.rideRecyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = RideListAdapter(ridesDB.getRidesList()) {scooterId ->
            findNavController().navigate(
                RideListFragmentDirections.showUpdateRide(scooterId)
            )
        }

        binding.rideRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(
            StartRideFragment.REQUEST_KEY_NEW_SCOOTER
        ) {
            _, bundle ->
            val newScooter = bundle.getSerializable(StartRideFragment.BUNDLE_KEY_NEW_SCOOTER) as Scooter
            ridesDB.addScooter(newScooter)
        }

        setFragmentResultListener(
            UpdateRideFragment.REQUEST_KEY_UPDATED_SCOOTER_LOCATION
        ) {
                _, bundle ->
            val newLocation = bundle.getSerializable(UpdateRideFragment.BUNDLE_KEY_UPDATED_SCOOTER_LOCATION) as Scooter
            ridesDB.updateScooterLocation(newLocation.name, newLocation.location)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_new_ride, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_ride -> {
                showNewRide()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showNewRide() {
        viewLifecycleOwner.lifecycleScope.launch {
            findNavController().navigate(
                RideListFragmentDirections.showStartRide()
            )
        }
    }

}