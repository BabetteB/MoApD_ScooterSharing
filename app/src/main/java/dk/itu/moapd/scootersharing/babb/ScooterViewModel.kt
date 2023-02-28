package dk.itu.moapd.scootersharing.babb

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "ScooterViewModel"
const val CURRENT_SCOOTER = "CURRENT_SCOOTER"

class ScooterViewModel(private val savedStateHandle: SavedStateHandle)  : ViewModel() {

    private var currentScooter: Scooter
        get() = savedStateHandle[CURRENT_SCOOTER] ?: Scooter("", "")
        set(value) = savedStateHandle.set(CURRENT_SCOOTER, value)

    val scooterName: String
        get() = currentScooter.name

    val scooterLocation: String
        get() = currentScooter.location

    fun updateLocation(newLocation : String) {
        currentScooter.location = newLocation
    }


    fun scooterString ()  : String {
        return ("Scooter name: $scooterName, location: $scooterLocation, created at : ${currentScooter.createdAt}, time : ${currentScooter.timeStamp}")
    }
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel cleared")
    }

}