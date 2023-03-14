package dk.itu.moapd.scootersharing.babb.viewmodel

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import dk.itu.moapd.scootersharing.babb.DeleteScooterFragmentArgs

class DeleteScooterFragment : DialogFragment() {

    private val args : DeleteScooterFragmentArgs by navArgs()

    companion object {
        const val REQUEST_KEY_ANSWER = "REQUEST_KEY_ANSWER"
        const val BUNDLE_KEY_ANSWER = "BUNDLE_KEY_ANSWER"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.context)
        val scooterId = args.deletedScooterId

        with(builder) {
            setTitle("Delete Scooter")
            setMessage("Are you sure you want to delete scooter $scooterId ?")
            setPositiveButton("Delete") {
                _, _ ->
                setFragmentResult(REQUEST_KEY_ANSWER, bundleOf(BUNDLE_KEY_ANSWER to true))
            }
            setNegativeButton("Go back") {
                _, _ ->
                setFragmentResult(REQUEST_KEY_ANSWER, bundleOf(BUNDLE_KEY_ANSWER to false))
            }
        }

        return builder.create()
    }
}