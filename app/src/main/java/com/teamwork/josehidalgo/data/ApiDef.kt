package com.teamwork.josehidalgo.data

/**
 * Created by jnhidalgo on 17/1/18.
 */

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDef {
    @GET("/projects.json")
    fun getProjects(): Observable<Projects>

    @GET("/projects/{id}/tasks.json")
    fun getTasks(@Path("id") id: String): Observable<Tasks>
}