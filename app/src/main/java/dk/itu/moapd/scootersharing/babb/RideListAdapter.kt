package dk.itu.moapd.scootersharing.babb

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import dk.itu.moapd.scootersharing.babb.databinding.ListItemRideBinding

class RideHolder(
    val binding: ListItemRideBinding
 ) : RecyclerView.ViewHolder(binding.root){}

class RideListAdapter (private val rides: List<Scooter>)
    : RecyclerView.Adapter<RideHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : RideHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemRideBinding.inflate(inflater, parent, false)
        return RideHolder(binding)
    }

    override fun onBindViewHolder(holder: RideHolder, position: Int) {
        val ride = rides[position]
        holder.apply {
            binding.scooterName.text = ride.name
            binding.scooterLocation.text = ride.location
        }
    }
    override fun getItemCount() = rides.size

}