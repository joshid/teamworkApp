package com.teamwork.josehidalgo.domain.usecases

import com.teamwork.josehidalgo.data.TwApiInterface
import com.teamwork.josehidalgo.domain.DomainProject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestProjectsUsecase @Inject constructor(private val api: TwApiInterface) {

    fun execute(): Observable<DomainProject> {

        return api.loadProjects()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}