package com.teamwork.josehidalgo.ui.mvp.presenter

import com.teamwork.josehidalgo.data.Projects
import com.teamwork.josehidalgo.domain.usecases.RequestProjectsUsecase
import com.teamwork.josehidalgo.ui.mvp.view.TWView
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by jnhidalgo on 21/1/18.
 */

class MainPresenter() {

    var disposable: Disposable? = null
    var view: TWView<Projects>? = null

    @Inject
    lateinit var requestProjectsUsecase: RequestProjectsUsecase

    @Inject
    constructor(requestProjectsUsecase: RequestProjectsUsecase) : this() {
        this.requestProjectsUsecase = requestProjectsUsecase
    }

    fun getProjects() {
        disposable = requestProjectsUsecase.execute()
                .subscribe(
                        { result -> view?.showItems(result) },
                        { error -> view?.showMessage("Error") }
                )
    }
}