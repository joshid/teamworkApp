package com.teamwork.josehidalgo.domain.usecases

import com.teamwork.josehidalgo.data.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RequestTasksUsecase(private val projectId: String) : Usecase<DomainTask> {

    val apiService by lazy {
        ApiService()
    }

    override fun execute(): Observable<DomainTask> {

        return apiService.loadTasks(projectId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}