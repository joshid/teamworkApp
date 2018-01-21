package com.teamwork.josehidalgo.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.domain.DomainTask
import com.teamwork.josehidalgo.extensions.ctx
import com.teamwork.josehidalgo.extensions.loadImg
import com.teamwork.josehidalgo.extensions.toDate
import com.teamwork.josehidalgo.extensions.toDateString
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(private val tasks: List<DomainTask>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTask(tasks[position])
    }

    override fun getItemCount() = tasks.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTask(task: DomainTask) {
            with(task) {
                itemView.taskContent.text = taskContent
                itemView.taskList.text = taskList
                itemView.taskCreateOn.text = "Created on ${taskCreatedOn.toDate().toDateString()}"
                itemView.taskEstimated.text = if (taskEstimated>0) "$taskEstimated min" else itemView.ctx.getString(R.string.no_estimated)
                itemView.taskCreator.loadImg(taskCreatorIcon)
            }
        }
    }
}