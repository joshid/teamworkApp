package com.teamwork.josehidalgo.ui.mvp.presenter

import com.teamwork.josehidalgo.domain.DomainProject
import com.teamwork.josehidalgo.domain.usecases.RequestProjectsUsecase
import com.teamwork.josehidalgo.ui.mvp.view.TWView
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by jnhidalgo on 21/1/18.
 */

class MainPresenter() {

    var disposable: Disposable? = null
    var view: TWView<List<DomainProject>>? = null
    var projects = mutableListOf<DomainProject>()

    @Inject
    lateinit var requestProjectsUsecase: RequestProjectsUsecase

    @Inject
    constructor(requestProjectsUsecase: RequestProjectsUsecase) : this() {
        this.requestProjectsUsecase = requestProjectsUsecase
    }

    fun getProjects() {
        disposable = requestProjectsUsecase.execute()
                .subscribe(
                        { project -> projects.add(project) },
                        { error -> view?.showMessage("Error") },
                        { view?.showItems(projects) }
                )
    }
}