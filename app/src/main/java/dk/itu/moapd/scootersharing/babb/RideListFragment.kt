package dk.itu.moapd.scootersharing.babb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dk.itu.moapd.scootersharing.babb.databinding.FragmentRideListBinding

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
        val adapter = RideListAdapter(rides.getRidesList())
        binding.rideRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}