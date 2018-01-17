package com.teamwork.josehidalgo.ui

import android.app.Application
import com.teamwork.josehidalgo.extensions.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}