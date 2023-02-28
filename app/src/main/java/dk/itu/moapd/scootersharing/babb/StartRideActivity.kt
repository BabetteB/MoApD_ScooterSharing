package dk.itu.moapd.scootersharing.babb

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import dk.itu.moapd.scootersharing.babb.databinding.ActivityStartRideBinding

const val EXTRA_START_SCOOTER_NAME = "java.dk.itu.moapd.scootersharing.babb.scooter_name"
const val EXTRA_START_SCOOTER_LOCATION = "java.dk.itu.moapd.scootersharing.babb.scooter_location"

class StartRideActivity : AppCompatActivity() {

    private lateinit var startRideBinding : ActivityStartRideBinding
    private val scooter : Scooter = Scooter("", "")

    companion object{
        private val TAG = StartRideActivity::class.qualifiedName

        /*fun newIntent (packageContext: Context, scooterName: String, scooterLocation: String) : Intent {
            return Intent(packageContext, StartRideActivity::class.java).apply {
                putExtra(EXTRA_START_SCOOTER_NAME, scooterName)
                putExtra(EXTRA_START_SCOOTER_LOCATION, scooterLocation)
            }
        }*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startRideBinding = ActivityStartRideBinding.inflate(layoutInflater)


        with (startRideBinding) {
            buttonStartRide.setOnClickListener {
                if (informationInput.nameInput.text.isNotEmpty() && informationInput.locationInput.text.isNotEmpty()) {

                    var name = informationInput.nameInput.text.toString().trim()
                    //scooter.name = name

                    var location = informationInput.locationInput.text.toString().trim()
                    scooter.location = location

                    setScooterData(name, location)

                    Snackbar.make(
                        startRideBinding.root,
                        scooter.toString(),
                        Snackbar.LENGTH_SHORT
                    ).show()

                    showMessage()
                }
            }
        }

        setContentView(startRideBinding.root)
    }


    private fun setScooterData(scooterName : String, scooterLocation : String) {
        val data = Intent().apply {
            putExtra(EXTRA_START_SCOOTER_NAME, scooterName)
            putExtra(EXTRA_START_SCOOTER_LOCATION, scooterLocation)
        }
        setResult(Activity.RESULT_OK, data)
    }

    private fun showMessage() {
        Log.d(TAG, scooter.toString())
    }


}