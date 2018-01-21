package com.teamwork.josehidalgo.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamwork.josehidalgo.R
import com.teamwork.josehidalgo.domain.DomainProject
import com.teamwork.josehidalgo.extensions.ctx
import com.teamwork.josehidalgo.extensions.loadImg
import com.teamwork.josehidalgo.extensions.toDate
import com.teamwork.josehidalgo.extensions.toDateString
import kotlinx.android.synthetic.main.item_project.view.*

class ProjectsAdapter(private val projects: List<DomainProject>, private val itemClick: (DomainProject) -> Unit) : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_project, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProject(projects[position])
    }

    override fun getItemCount() = projects.size

    class ViewHolder(view: View, private val itemClick: (DomainProject) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindProject(project: DomainProject) {
            with(project) {
                itemView.logo.loadImg(projectLogo)
                itemView.name.text = projectName
                itemView.description.text = projectDescription
                itemView.createdOn.text = itemView.ctx.getString(R.string.created_on) + " ${projectCreationDate.toDate().toDateString()}"
                itemView.lastChangeOn.text = itemView.ctx.getString(R.string.last_change_on) + " ${projectChangeDate.toDate().toDateString()}"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}