package dk.itu.moapd.scootersharing.babb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import dk.itu.moapd.scootersharing.babb.databinding.ActivityStartRideBinding

class StartRideActivity : AppCompatActivity() {

    private lateinit var startRideBinding : ActivityStartRideBinding
    private val scooter : Scooter = Scooter("", "")

    companion object{
        private val TAG = StartRideActivity::class.qualifiedName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startRideBinding = ActivityStartRideBinding.inflate(layoutInflater)

        with (startRideBinding) {

        }

        setContentView(startRideBinding.root)
    }


    private fun showMessage() {
        Log.d(StartRideActivity.TAG, scooter.toString())
    }


}