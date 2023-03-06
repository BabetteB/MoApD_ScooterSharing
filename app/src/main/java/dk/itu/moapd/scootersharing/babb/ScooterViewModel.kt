package dk.itu.moapd.scootersharing.babb

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScooterViewModel(val savedStateHandle: SavedStateHandle)  : ViewModel() {

    companion object {
        private val TAG = ScooterViewModel::class.qualifiedName
        const val CURRENT_SCOOTER_LIST = "CURRENT_SCOOTER_LIST"
        lateinit var scooterBank : RidesDB
    }

    private var currentScooter: ArrayList<Scooter>
        get() = savedStateHandle[CURRENT_SCOOTER_LIST] ?: ArrayList()
        set(value) = savedStateHandle.set(CURRENT_SCOOTER_LIST, value)

    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel cleared")
    }

}