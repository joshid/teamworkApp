package com.teamwork.josehidalgo.ui

import android.app.Application
import com.teamwork.josehidalgo.di.AppComponent
import com.teamwork.josehidalgo.di.AppModule
import com.teamwork.josehidalgo.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                //.dataModule(DataModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }
}