package com.teamwork.josehidalgo.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.crashlytics.android.Crashlytics
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.data.Projects
import com.teamwork.josehidalgo.domain.usecases.RequestProjectsUsecase
import com.teamwork.josehidalgo.ui.App
import com.teamwork.josehidalgo.ui.adapter.ProjectsAdapter
import com.teamwork.josehidalgo.ui.utils.ToolbarManager
import io.fabric.sdk.android.Fabric
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    @Inject lateinit var requestProjectsUsecase: RequestProjectsUsecase

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())

        setContentView(R.layout.activity_main)

        App.appComponent.inject(this)

        swipeContainer.setOnRefreshListener { loadProjects() }
        swipeContainer.setColorSchemeResources(R.color.theme_primary, R.color.theme_accent)

        projectList.layoutManager = LinearLayoutManager(this)
        attachToScroll(projectList)
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onResume() {
        super.onResume()
        loadProjects()
    }

    private fun loadProjects() {
        disposable = requestProjectsUsecase.execute()
                .subscribe(
                        { result -> swipeContainer.isRefreshing = false
                                    updateUI(result) },
                        { error -> swipeContainer.isRefreshing = false
                                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
                )
    }

    private fun updateUI(projects: Projects) {
        val adapter = ProjectsAdapter(projects) {
            startActivity<DetailActivity>(DetailActivity.ID to it.id, DetailActivity.NAME to it.name)
        }
        projectList.adapter = adapter
        toolbarTitle =  "${projects.size} " + getString(R.string.activity_project_name)
    }
}
