package com.teamwork.josehidalgo.data

/**
 * Created by jnhidalgo on 14/1/18.
 */

import com.teamwork.josehidalgo.domain.usecases.DomainTask
import io.reactivex.Observable
import javax.inject.Inject

class ApiService @Inject constructor(private val apiDef: ApiDef) : TwApiInterface {

    override fun loadProjects(): Observable<Projects> {
        return apiDef.getProjects()
    }

    override fun loadTasks(id: String): Observable<DomainTask> {
        return apiDef.getTasks(id)
                .flatMap { tasksResults -> Observable.fromIterable(tasksResults.todoItems) }
                .filter { task -> task.status == "new" }
                .map { task -> DomainTask( task.content, task.todoListName, task.createdOn, task.estimatedMinutes, task.creatorAvatarUrl) }
                .take(10)
    }

}