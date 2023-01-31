package dk.itu.moapd.scootersharing.babb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // set of private constants used in this class
    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }

    // GUI vars
    private lateinit var scooterName: EditText
    private val scooter:


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}