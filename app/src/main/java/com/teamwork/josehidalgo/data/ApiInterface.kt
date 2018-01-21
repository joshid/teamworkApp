package com.teamwork.josehidalgo.data

import com.teamwork.josehidalgo.domain.DomainProject
import com.teamwork.josehidalgo.domain.DomainTask
import io.reactivex.Observable

/**
 * Created by jnhidalgo on 17/1/18.
 */

interface TwApiInterface {

    fun loadProjects(): Observable<DomainProject>
    fun loadTasks(id: String): Observable<DomainTask>
}