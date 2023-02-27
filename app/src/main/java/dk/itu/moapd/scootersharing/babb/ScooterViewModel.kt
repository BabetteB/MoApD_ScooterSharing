package dk.itu.moapd.scootersharing.babb

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "ScooterViewModel"
const val CURRENT_SCOOTER = "CURRENT_SCOOTER"

class ScooterViewModel(private val savedStateHandle: SavedStateHandle)  : ViewModel() {

    var currentScooter: Scooter
        get() = savedStateHandle.get(CURRENT_SCOOTER) ?: Scooter("", "")
        set(value) = savedStateHandle.set(CURRENT_SCOOTER, value)


    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel cleared")
    }

}