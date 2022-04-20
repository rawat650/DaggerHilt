package com.example.userlistapp.di

import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(private val sharedPrefManager: SharedPrefManager) {

    var loggedInUserId : Int?  = null

    fun setToken(token : String?)  = sharedPrefManager.setSessionToken(token)
    fun setIdToken(idToken : String?)  = sharedPrefManager.setSessionIdToken(idToken)

    fun getToken() : String? = sharedPrefManager.getSessionToken()
    fun getIdToken() : String? = sharedPrefManager.getSessionIdToken()

    fun setRefreshToken(refreshToken : String?)  = sharedPrefManager.setRefreshToken(refreshToken)

    fun getRefreshToken() : String? = sharedPrefManager.getRefreshToken()

    fun setIsLoggedIn(isLoggedIn : Boolean) = sharedPrefManager.setIsLoggedIn(isLoggedIn)

    fun setDeliveryAgentActive(isLoggedIn : Boolean) = sharedPrefManager.setDeliveryAgentActive(isLoggedIn)

    fun isLoggedIn() = sharedPrefManager.getIsLoggedIn()

    fun setUserID(username : String?)  = sharedPrefManager.setUserID(username)

    fun getUserID() : String? = sharedPrefManager.getUserID()

    fun getDeliveryAgentActive() : Boolean? = sharedPrefManager.getDeliveryAgentActive()

    fun setIsContactsSynced(status : Boolean)  = sharedPrefManager.setIsContactsSynced(status)

    fun getIsContactsSynced() : Boolean = sharedPrefManager.getIsContactsSynced()

    private fun clearPreference() = sharedPrefManager.clearPreference()

   /* fun setUserDetails(userDetails: ProfileDetails?) {
        userDetails?.let {
            val userDetailsString : String? = Gson().toJson(userDetails)
            sharedPrefManager.setUserDetails(userDetailsString)
        }
    }

    fun getUserDetails() : ProfileDetails? {
        val userDetailsString : String? = sharedPrefManager.getUserDetails()
        if (!userDetailsString.isNullOrEmpty()) {
            return Gson().fromJson(userDetailsString, ProfileDetails::class.java) as ProfileDetails
        }
        return null
    }*/

    fun setDeviceToken(token : String?)  = sharedPrefManager.setDeviceToken(token)

    fun getDeviceToken() : String? = sharedPrefManager.getDeviceToken()
    fun setDashBoardTileArray(dashboardTileArray:String?) = sharedPrefManager.setDashBoardTileArray(dashboardTileArray)
    fun getDashBoardTileArray() = sharedPrefManager.getDashBoardTileArray()


    fun clearAllData() {
        /*setToken("")
        setRefreshToken("")
        setIsLoggedIn(false)
        setUserID("")
        setUserDetails(null)
        setIsContactsSynced(false)*/
        val isContactSync = getIsContactsSynced()
        clearPreference()
        setIsContactsSynced(isContactSync)
    }
}