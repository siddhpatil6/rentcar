package com.example.rentcar.custom

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaFormat.KEY_PROFILE
import com.example.rentcar.ui.models.ProfileResponseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferenceManager(context: Context) {

    companion object {
        private const val PREF_NAME = "MyPrefs"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
        private const val KEY_USERNAME = "username"
        private const val KEY_EMAIL = "email"
        private const val KEY_PROFILE = "key_profile"

        // Add more keys for other profile details
    }
    private val gson = Gson()

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
        set(value) = sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()

    var username: String?
        get() = sharedPreferences.getString(KEY_USERNAME, null)
        set(value) = sharedPreferences.edit().putString(KEY_USERNAME, value).apply()

    var email: String?
        get() = sharedPreferences.getString(KEY_EMAIL, null)
        set(value) = sharedPreferences.edit().putString(KEY_EMAIL, value).apply()

    fun saveProfile(profile: ProfileResponseModel) {
        val json = gson.toJson(profile)
        sharedPreferences.edit().putString(KEY_PROFILE, json).apply()
    }

    fun getProfile(): ProfileResponseModel? {
        val json = sharedPreferences.getString(KEY_PROFILE, null)
        return gson.fromJson(json, object : TypeToken<ProfileResponseModel>() {}.type)
    }

    fun clearProfile() {
        sharedPreferences.edit().remove(KEY_PROFILE).apply()
    }
    // Add more getters and setters for other profile details
}