package com.teamwork.josehidalgo.di

import com.teamwork.josehidalgo.ui.activity.DetailActivity
import com.teamwork.josehidalgo.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        DataModule::class,
        NetworkModule::class)
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)


}