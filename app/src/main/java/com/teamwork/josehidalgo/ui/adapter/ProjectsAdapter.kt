package com.teamwork.josehidalgo.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.data.Project
import com.teamwork.josehidalgo.data.Projects
import com.teamwork.josehidalgo.extensions.ctx
import com.teamwork.josehidalgo.extensions.loadImg
import com.teamwork.josehidalgo.extensions.toDate
import com.teamwork.josehidalgo.extensions.toDateString
import kotlinx.android.synthetic.main.item_project.view.*

class ProjectsAdapter(private val projects: Projects, private val itemClick: (Project) -> Unit) : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_project, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProject(projects[position])
    }

    override fun getItemCount() = projects.size

    class ViewHolder(view: View, private val itemClick: (Project) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindProject(project: Project) {
            with(project) {
                itemView.logo.loadImg(logo)
                itemView.name.text = name
                itemView.description.text = description
                itemView.createdOn.text = itemView.ctx.getString(R.string.created_on) + " ${createdOn.toDate().toDateString()}"
                itemView.lastChangeOn.text = itemView.ctx.getString(R.string.last_change_on) + " ${lastChangedOn.toDate().toDateString()}"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}