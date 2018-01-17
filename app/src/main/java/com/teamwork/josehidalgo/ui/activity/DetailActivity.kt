package com.teamwork.josehidalgo.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.domain.usecases.DomainTask
import com.teamwork.josehidalgo.domain.usecases.RequestTasksUsecase
import com.teamwork.josehidalgo.ui.adapter.TaskAdapter
import com.teamwork.josehidalgo.ui.utils.ToolbarManager
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.find

class DetailActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    var disposable: Disposable? = null
    lateinit var taskAdapter : TaskAdapter
    var tasks = mutableListOf<DomainTask>()

    companion object {
        val ID = "DetailActivity:id"
        val NAME = "DetailActivity:name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbarTitle = intent.getStringExtra(NAME) + " " + ctx.getString(R.string.new_tasks)
        enableHomeAsUp { onBackPressed() }

        tasksLists.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(tasks)
        tasksLists.adapter = taskAdapter
        attachToScroll(tasksLists)
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onResume() {
        super.onResume()
        loadTasks()
    }

    private fun loadTasks() {
        val requestTasks = RequestTasksUsecase(intent.getStringExtra(ID))
        disposable = requestTasks.execute()
                .subscribe(
                        { task -> tasks.add(task) },
                        { error -> Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() },
                        { taskAdapter.notifyDataSetChanged() }
                )
    }
}