package com.teamwork.josehidalgo.ui.mvp.presenter

import com.teamwork.josehidalgo.domain.DomainTask
import com.teamwork.josehidalgo.domain.usecases.RequestTasksUsecase
import com.teamwork.josehidalgo.ui.mvp.view.TWView
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by jnhidalgo on 21/1/18.
 */

class DetailPresenter() {

    var projectID : String? = null
    var disposable: Disposable? = null
    var view: TWView<List<DomainTask>>? = null
    var tasks = mutableListOf<DomainTask>()

    @Inject
    lateinit var requestTasksUsecase: RequestTasksUsecase

    @Inject
    constructor(requestTasksUsecase: RequestTasksUsecase) : this() {
        this.requestTasksUsecase = requestTasksUsecase
    }

    fun getTasks() {

        projectID?.let {
            disposable = requestTasksUsecase.execute(projectID as String)
                    .subscribe(
                            { task -> tasks.add(task) },
                            { error -> view?.showMessage("Error") },
                            { view?.showItems(tasks) }
                    )
        }
    }
}