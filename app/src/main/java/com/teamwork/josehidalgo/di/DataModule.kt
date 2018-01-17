package com.teamwork.josehidalgo.di

import com.teamwork.josehidalgo.data.ApiDef
import com.teamwork.josehidalgo.data.ApiService
import com.teamwork.josehidalgo.data.TwApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideApi(apiDef: ApiDef): TwApiInterface = ApiService(apiDef)

    @Provides
    @Singleton
    fun provideTWApi(retrofit: Retrofit): ApiDef = retrofit.create(ApiDef::class.java)
}
