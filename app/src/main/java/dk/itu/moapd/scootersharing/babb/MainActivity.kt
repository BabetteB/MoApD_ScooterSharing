/*MIT License

Copyright (c) [2023] [Babette & Freyja]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package dk.itu.moapd.scootersharing.babb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import dk.itu.moapd.scootersharing.babb.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    // Binding(s)
    private lateinit var mainBinding : ActivityMainBinding
    private val scooterViewModel : ScooterViewModel by viewModels()


    private val updateRideLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
        if(result.resultCode == Activity.RESULT_OK) {
            scooterViewModel.currentScooter.location =
                result.data?.getStringExtra(EXTRA_UPDATE_SCOOTER_LOCATION) ?: "NaN"
        }
        Log.d(TAG, result.toString())
    }

    private val startRideLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if(result.resultCode == Activity.RESULT_OK) {
            scooterViewModel.currentScooter.name =
                result.data?.getStringExtra(EXTRA_START_SCOOTER_NAME) ?: "NaN"
            scooterViewModel.currentScooter.location =
                result.data?.getStringExtra(EXTRA_START_SCOOTER_LOCATION) ?: "NaN"
        }
        Log.d(TAG, result.toString())
    }

    // set of private constants used in this class
    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        Log.d(TAG, "created ScooterViewModel: $scooterViewModel")

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        with (mainBinding) {
            buttonStartRide.setOnClickListener {
                val intent = StartRideActivity.newIntent(this@MainActivity, scooterViewModel.currentScooter.name, scooterViewModel.currentScooter.location)
                startRideLauncher.launch(intent)
            }

            buttonUpdateRide.setOnClickListener {
                val intent = UpdateRideActivity.newIntent(this@MainActivity, scooterViewModel.currentScooter.name)
                updateRideLauncher.launch(intent)
            }
        }

        setContentView(mainBinding.root)
    }

    private fun showMessage() {
        Log.d(TAG, scooterViewModel.currentScooter.toString())
    }
}