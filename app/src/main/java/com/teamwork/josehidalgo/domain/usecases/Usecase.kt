package com.teamwork.josehidalgo.domain.usecases

import io.reactivex.Observable

interface Usecase<T> {
    fun execute(): Observable<T>
}