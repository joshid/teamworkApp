package com.teamwork.josehidalgo.domain.usecases

import com.teamwork.josehidalgo.data.ApiService
import com.teamwork.josehidalgo.data.Projects
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RequestProjectsUsecase() : Usecase<Projects> {

    val apiService by lazy {
        ApiService()
    }

    override fun execute(): Observable<Projects> {

        return apiService.loadProjects()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}