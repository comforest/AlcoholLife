package com.software.engineering.alcohollife

import android.app.Application
import com.software.engineering.alcohollife.util.SharedPreferenceUtil

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        prefs = SharedPreferenceUtil(this)
    }

    companion object {
        lateinit var prefs: SharedPreferenceUtil
            private set

    }
}