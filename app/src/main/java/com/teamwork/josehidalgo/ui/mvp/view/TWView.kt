package com.teamwork.josehidalgo.ui.mvp.view

/**
 * Created by jnhidalgo on 21/1/18.
 */

interface TWView<T> {

    fun showItems(items: T)

    fun showMessage(message: String)
}