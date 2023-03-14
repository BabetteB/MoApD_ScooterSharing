package dk.itu.moapd.scootersharing.babb

interface ItemClickListener {

    fun onRideClicked(scooterId : String)

    fun onRideLongClicked(scooterId : String)

}