package dk.itu.moapd.scootersharing.babb.viewmodel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dk.itu.moapd.scootersharing.babb.databinding.ActivityMainBinding

/**
 * The MainActivity is the sole activity, used for storing the MainFragment
 */
class MainActivity : AppCompatActivity() {

    /**
     * Binding view and activity
     */
    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    /**
     * upon creating the instance of main activity, inflate the binding (see activity_main.xml)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser == null)
            startLoginActivity()
        val user = auth.currentUser
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}