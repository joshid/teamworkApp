package com.teamwork.josehidalgo.data

/**
 * Created by jnhidalgo on 14/1/18.
 */

import com.teamwork.josehidalgo.data.utils.BasicAuthInterceptor
import com.teamwork.josehidalgo.domain.usecases.DomainTask
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiService {

    companion object {

        private val baseURL = "https://yat.teamwork.com"
        private val teamworkAPI = "twp_TEbBXGCnvl2HfvXWfkLUlzx92e3T"
        private val dummyPwd = "teamwork"
    }

    val service : ApiDef

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(BasicAuthInterceptor(teamworkAPI, dummyPwd))
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseURL)
                .build()

        service = retrofit.create<ApiDef>(ApiDef::class.java)
    }

    fun loadProjects(): Observable<Projects> {
        return service.getProjects()
    }

    fun loadTasks(id: String): Observable<DomainTask> {
        return service.getTasks(id)
                .flatMap { tasksResults -> Observable.fromIterable(tasksResults.todoItems) }
                .filter { task -> task.status == "new" }
                .map { task -> DomainTask( task.content, task.todoListName, task.createdOn, task.estimatedMinutes, task.creatorAvatarUrl) }
                .take(10)
    }

}