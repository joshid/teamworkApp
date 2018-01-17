package com.teamwork.josehidalgo.data
import com.squareup.moshi.Json


/**
 * Created by jnhidalgo on 16/1/18.
 */

data class Tasks(
		@Json(name = "STATUS") val sTATUS: String, //OK
		@Json(name = "todo-items") val todoItems: List<TodoItem>
) {
	val size: Int
		get() = todoItems.size

	operator fun get(position: Int) = todoItems[position]
}

data class TodoItem(
		@Json(name = "id") val id: Int, //13533208
		@Json(name = "canComplete") val canComplete: Boolean, //true
		@Json(name = "comments-count") val commentsCount: Int, //0
		@Json(name = "description") val description: String, //hbghh
		@Json(name = "has-reminders") val hasReminders: Boolean, //false
		@Json(name = "has-unread-comments") val hasUnreadComments: Boolean, //false
		@Json(name = "private") val private: Int, //0
		@Json(name = "content") val content: String, //Making of task one
		@Json(name = "order") val order: Int, //2020
		@Json(name = "project-id") val projectId: Int, //339988
		@Json(name = "project-name") val projectName: String, //Adamantium
		@Json(name = "todo-list-id") val todoListId: Int, //1115157
		@Json(name = "todo-list-name") val todoListName: String, //General tasks
		@Json(name = "tasklist-private") val tasklistPrivate: Boolean, //false
		@Json(name = "tasklist-isTemplate") val tasklistIsTemplate: Boolean, //false
		@Json(name = "status") val status: String, //reopened
		@Json(name = "company-name") val companyName: String, //Cat
		@Json(name = "company-id") val companyId: Int, //113332
		@Json(name = "creator-id") val creatorId: Int, //230907
		@Json(name = "creator-firstname") val creatorFirstname: String, //Cat
		@Json(name = "creator-lastname") val creatorLastname: String, //Cat
		@Json(name = "completed") val completed: Boolean, //false
		@Json(name = "start-date") val startDate: String,
		@Json(name = "due-date-base") val dueDateBase: String,
		@Json(name = "due-date") val dueDate: String,
		@Json(name = "created-on") val createdOn: String, //2017-08-16T16:38:55Z
		@Json(name = "last-changed-on") val lastChangedOn: String, //0001-01-01T00:00:00Z
		@Json(name = "position") val position: Int, //2020
		@Json(name = "estimated-minutes") val estimatedMinutes: Int, //50
		@Json(name = "priority") val priority: String,
		@Json(name = "progress") val progress: Int, //0
		@Json(name = "harvest-enabled") val harvestEnabled: Boolean, //false
		@Json(name = "parentTaskId") val parentTaskId: String,
		@Json(name = "lockdownId") val lockdownId: String,
		@Json(name = "tasklist-lockdownId") val tasklistLockdownId: String,
		@Json(name = "has-dependencies") val hasDependencies: Int, //0
		@Json(name = "has-predecessors") val hasPredecessors: Int, //0
		@Json(name = "hasTickets") val hasTickets: Boolean, //false
		@Json(name = "timeIsLogged") val timeIsLogged: String, //0
		@Json(name = "attachments-count") val attachmentsCount: Int, //0
		@Json(name = "predecessors") val predecessors: List<Any>,
		@Json(name = "canEdit") val canEdit: Boolean, //true
		@Json(name = "viewEstimatedTime") val viewEstimatedTime: Boolean, //true
		@Json(name = "creator-avatar-url") val creatorAvatarUrl: String, //https://s3.amazonaws.com/TWFiles/349705/userAvatar/tf_C21F3016-CD19-C60F-E82B23120C506FEE.Tac_the_Psychotic_Cat.jpg
		@Json(name = "canLogTime") val canLogTime: Boolean, //true
		@Json(name = "userFollowingComments") val userFollowingComments: Boolean, //false
		@Json(name = "userFollowingChanges") val userFollowingChanges: Boolean, //false
		@Json(name = "DLM") val dLM: Int //0
)