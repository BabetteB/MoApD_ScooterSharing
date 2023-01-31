package dk.itu.moapd.scootersharing.babb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {

    // GUI vars
    private lateinit var scooterName: EditText
    private lateinit var scooterLocation: EditText
    private val scooter: Scooter = Scooter("", "")
    private lateinit var buttonStartRide: Button

    // set of private constants used in this class
    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scooterName = findViewById(R.id.edit_text_name)
        scooterLocation = findViewById(R.id.edit_text_location)
        buttonStartRide = findViewById(R.id.button_start_ride)
        buttonStartRide.setOnClickListener{
            if (scooterName.text.isNotEmpty() && scooterLocation.text.isNotEmpty())
            {
                val name = scooterName.text.toString().trim()
                scooter.setName(name)

                val location = scooterLocation.text.toString().trim()
                scooter.setLocation(location)

                showMessage()
            }

        }
    }

    private fun showMessage() {
        Log.d(TAG, scooter.toString())
    }
}