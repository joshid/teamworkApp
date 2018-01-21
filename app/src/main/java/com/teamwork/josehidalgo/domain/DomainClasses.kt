package com.teamwork.josehidalgo.domain

/**
 * Created by jnhidalgo on 17/1/18.
 */

data class DomainProject (val projectID : String,
                          val projectName : String,
                          val projectDescription : String,
                          val projectLogo : String,
                          val projectCreationDate : String,
                          val projectChangeDate : String)

data class DomainTask (val taskContent : String,
                       val taskList : String,
                       val taskCreatedOn : String,
                       val taskEstimated : Int,
                       val taskCreatorIcon : String)
