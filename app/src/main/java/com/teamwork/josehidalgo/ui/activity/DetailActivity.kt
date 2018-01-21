package com.teamwork.josehidalgo.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.domain.DomainTask
import com.teamwork.josehidalgo.ui.App
import com.teamwork.josehidalgo.ui.adapter.TaskAdapter
import com.teamwork.josehidalgo.ui.mvp.presenter.DetailPresenter
import com.teamwork.josehidalgo.ui.mvp.view.TWView
import com.teamwork.josehidalgo.ui.utils.ToolbarManager
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), ToolbarManager, TWView<List<DomainTask>> {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    @Inject lateinit var presenter: DetailPresenter

    companion object {
        val ID = "DetailActivity:id"
        val NAME = "DetailActivity:name"
    }

    /////////////////////////////////////////////////////////////////
    //                                                             //
    //                    LIFECYCLE METHODS                        //
    //                                                             //
    /////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        App.appComponent.inject(this)

        presenter.view = this
        presenter.projectID = intent.getStringExtra(ID)

        toolbarTitle = intent.getStringExtra(NAME) + " " + ctx.getString(R.string.new_tasks)
        enableHomeAsUp { onBackPressed() }

        tasksLists.layoutManager = LinearLayoutManager(this)
        attachToScroll(tasksLists)
    }

    override fun onPause() {
        super.onPause()
        presenter.disposable?.dispose()
    }

    override fun onResume() {
        super.onResume()
        presenter.getTasks()
    }

    /////////////////////////////////////////////////////////////////
    //                                                             //
    //                    INTERFACE METHODS                        //
    //                                                             //
    /////////////////////////////////////////////////////////////////

    override fun showItems(tasks: List<DomainTask>) {
        val adapter = TaskAdapter(tasks)
        tasksLists.adapter = adapter
    }

    override fun showMessage(message: String) {
        toast(message)
    }
}