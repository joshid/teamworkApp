package com.teamwork.josehidalgo.domain.usecases

import com.teamwork.josehidalgo.data.TwApiInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RequestTasksUsecase @Inject constructor(private val api: TwApiInterface) {

    fun execute(projectId: String): Observable<DomainTask> {

        return api.loadTasks(projectId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}