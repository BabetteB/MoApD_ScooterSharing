package dk.itu.moapd.scootersharing.babb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.view.WindowCompat
import com.google.android.material.snackbar.Snackbar
import dk.itu.moapd.scootersharing.babb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding(s)
    private lateinit var mainBinding : ActivityMainBinding

    // GUI vars
    private val scooter: Scooter = Scooter("", "")

    // set of private constants used in this class
    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }

    /**
     * Binds view when App is launched
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        with (mainBinding) {
            inputStartRideLayout.buttonStartRide.setOnClickListener {
                if (inputStartRideLayout.nameInput.text.isNotEmpty() && inputStartRideLayout.locationInput.text.isNotEmpty()) {
                    var name = inputStartRideLayout.nameInput.text.toString().trim()
                    scooter.name = name

                    var location = inputStartRideLayout.locationInput.text.toString().trim()
                    scooter.location = location

                    Snackbar.make(
                        mainBinding.snackbarAction,
                        scooter.toString(),
                        Snackbar.LENGTH_SHORT).show()

                    showMessage()
                }
            }
        }

        setContentView(mainBinding.root)
    }

    /**
     * Logs the Scooter properties
     */
    private fun showMessage() {
        Log.d(TAG, scooter.toString())
    }
}