package com.teamwork.josehidalgo.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.crashlytics.android.Crashlytics
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.domain.DomainProject
import com.teamwork.josehidalgo.ui.App
import com.teamwork.josehidalgo.ui.adapter.ProjectsAdapter
import com.teamwork.josehidalgo.ui.mvp.presenter.MainPresenter
import com.teamwork.josehidalgo.ui.mvp.view.TWView
import com.teamwork.josehidalgo.ui.utils.ToolbarManager
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ToolbarManager, TWView<List<DomainProject>> {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    @Inject lateinit var presenter: MainPresenter

    /////////////////////////////////////////////////////////////////
    //                                                             //
    //                    LIFECYCLE METHODS                        //
    //                                                             //
    /////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        App.appComponent.inject(this)

        presenter.view = this
        presenter.getProjects()

        swipeContainer.setOnRefreshListener { presenter.getProjects() }

        projectList.layoutManager = LinearLayoutManager(this)
        attachToScroll(projectList)
    }

    override fun onPause() {
        super.onPause()
        presenter.disposable?.dispose()
    }

    /////////////////////////////////////////////////////////////////
    //                                                             //
    //                    INTERFACE METHODS                        //
    //                                                             //
    /////////////////////////////////////////////////////////////////

    override fun showItems(projects: List<DomainProject>) {
        val adapter = ProjectsAdapter(projects) {
            startActivity<DetailActivity>(DetailActivity.ID to it.projectID, DetailActivity.NAME to it.projectName)
        }
        projectList.adapter = adapter
        toolbarTitle =  "${projects.size} " + getString(R.string.activity_project_name)
    }

    override fun showMessage(message: String) {
        toast(message)
    }
}
