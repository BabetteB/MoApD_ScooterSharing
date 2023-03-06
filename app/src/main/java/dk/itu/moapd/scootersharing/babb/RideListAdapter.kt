package dk.itu.moapd.scootersharing.babb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.itu.moapd.scootersharing.babb.databinding.ListItemRideBinding

class RideHolder(
    private val binding: ListItemRideBinding
 ) : RecyclerView.ViewHolder(binding.root){
     fun bind (scooter : Scooter, onRideClicked: (scooterId: String) -> Unit){
         binding.scooterName.text = scooter.name
         binding.scooterLocation.text = scooter.location
         binding.scooterLastUpdate.text =scooter.lastUpdateTimeStamp.toString()

         binding.cardView.setOnClickListener {
             onRideClicked(scooter.name)
         }

     }
 }

class RideListAdapter (private val rides: List<Scooter>,
                       private val onRideClicked: (scooterId: String) -> Unit
)    : RecyclerView.Adapter<RideHolder>() {



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
        holder.bind(ride, onRideClicked)
    }
    override fun getItemCount() = rides.size

}