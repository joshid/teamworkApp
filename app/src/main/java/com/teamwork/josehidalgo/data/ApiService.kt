package com.teamwork.josehidalgo.data

/**
 * Created by jnhidalgo on 14/1/18.
 */

import com.teamwork.josehidalgo.domain.DomainProject
import com.teamwork.josehidalgo.domain.DomainTask
import io.reactivex.Observable
import javax.inject.Inject

class ApiService @Inject constructor(private val apiDef: ApiDef) : TwApiInterface {

    override fun loadProjects(): Observable<DomainProject> {
        return apiDef.getProjects()
                .flatMap { projects -> Observable.fromIterable(projects.projects) }
                .map { project -> DomainProject(project.id, project.name, project.description, project.logo, project.createdOn, project.lastChangedOn) }
    }

    override fun loadTasks(id: String): Observable<DomainTask> {
        return apiDef.getTasks(id)
                .flatMap { tasks -> Observable.fromIterable(tasks.todoItems) }
                .filter { task -> task.estimatedMinutes > 0 }
                .sorted { o1, o2 ->  o1.estimatedMinutes-o2.estimatedMinutes}
                .map { task -> DomainTask(task.content, task.todoListName, task.createdOn, task.estimatedMinutes, task.creatorAvatarUrl) }
                .take(10)
    }

}