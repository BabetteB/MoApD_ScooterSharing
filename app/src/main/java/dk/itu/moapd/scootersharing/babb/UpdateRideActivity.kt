package dk.itu.moapd.scootersharing.babb

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import dk.itu.moapd.scootersharing.babb.databinding.ActivityUpdateRideBinding

const val EXTRA_UPDATE_SCOOTER_LOCATION = "java.dk.itu.moapd.scootersharing.babb.scooter_location"
const val EXTRA_UPDATE_SCOOTER_NAME = "Scooter name"

class UpdateRideActivity : AppCompatActivity() {

    private lateinit var updateRideBinding: ActivityUpdateRideBinding
    private val scooter : Scooter = Scooter("", "")


    companion object{
        private val TAG = UpdateRideActivity::class.qualifiedName

        fun newIntent (packageContext: Context, scooterName: String) : Intent {
            return Intent(packageContext, UpdateRideActivity::class.java).apply {
                putExtra(EXTRA_UPDATE_SCOOTER_NAME, scooterName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateRideBinding = ActivityUpdateRideBinding.inflate(layoutInflater)

        scooter.name = intent.getStringExtra(EXTRA_START_SCOOTER_NAME).toString()

        with (updateRideBinding) {

            informationInput.nameInput.setText(scooter.name)
            informationInput.nameInput.isEnabled = false

            buttonUpdateRide.setOnClickListener {
                if (informationInput.nameInput.text.isNotEmpty() && informationInput.locationInput.text.isNotEmpty()) {

                    var location = informationInput.locationInput.text.toString().trim()
                    scooter.location = location

                    setScooterData(location)

                    Snackbar.make(
                        updateRideBinding.root,
                        scooter.toString(),
                        Snackbar.LENGTH_SHORT
                    ).show()

                    showMessage()
                }
            }

        }

        setContentView(updateRideBinding.root)
    }

    private fun setScooterData(scooterLocation : String) {
        val data = Intent().apply {
            putExtra(EXTRA_UPDATE_SCOOTER_LOCATION, scooterLocation)
        }
        setResult(Activity.RESULT_OK, data)
    }

    private fun showMessage() {
        Log.d(TAG, scooter.toString())
    }
}