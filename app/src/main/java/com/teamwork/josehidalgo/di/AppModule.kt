package com.teamwork.josehidalgo.di

import android.app.Application
import android.content.Context
import com.teamwork.josehidalgo.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication() : Application = app

}