package dk.itu.moapd.scootersharing.babb

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
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

    companion object {
        lateinit var ridesDB : RidesDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ridesDB = RidesDB.get(this.requireActivity())

        setHasOptionsMenu(true)

        Log.d(TAG, "Total rides: ${ridesDB.getRidesList().size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRideListBinding.inflate(inflater, container, false)

        binding.rideRecyclerView.layoutManager = LinearLayoutManager(context)

        val rides = ridesDB
        val adapter = RideListAdapter(rides.getRidesList()) {scooterId ->
            findNavController().navigate(
                RideListFragmentDirections.showUpdateRide(scooterId)
            )
        }
        binding.rideRecyclerView.adapter = adapter

        return binding.root
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
        return  when (item.itemId) {
            R.id.new_ride -> {
                showNewRide()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showNewRide() {
        viewLifecycleOwner.lifecycleScope.launch {
            val newScooter = Scooter (
                name = "",
                location = ""
            )
            ridesDB.addScooter(newScooter)
            findNavController().navigate(
                RideListFragmentDirections.showStartRide()
            )
        }
    }

}