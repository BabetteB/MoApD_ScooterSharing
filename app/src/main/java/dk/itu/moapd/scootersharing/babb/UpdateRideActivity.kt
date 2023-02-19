package dk.itu.moapd.scootersharing.babb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dk.itu.moapd.scootersharing.babb.databinding.ActivityStartRideBinding
import dk.itu.moapd.scootersharing.babb.databinding.ActivityUpdateRideBinding

class UpdateRideActivity : AppCompatActivity() {

    private lateinit var updateRideBinding: ActivityUpdateRideBinding

    private val scooter : Scooter = Scooter("", "")

    companion object{
        private val TAG = UpdateRideActivity::class.qualifiedName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateRideBinding = ActivityUpdateRideBinding.inflate(layoutInflater)

        with (updateRideBinding) {

        }

        setContentView(updateRideBinding.root)
    }
}