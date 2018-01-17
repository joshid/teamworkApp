package com.teamwork.josehidalgo.data
import com.squareup.moshi.Json


/**
 * Created by jnhidalgo on 14/1/18.
 */


data class Projects(
		@Json(name = "STATUS") val sTATUS: String, //OK
		@Json(name = "projects") val projects: List<Project>
) {
	val size: Int
		get() = projects.size

	operator fun get(position: Int) = projects[position]
}

data class Project(
		@Json(name = "replyByEmailEnabled") val replyByEmailEnabled: Boolean, //true
		@Json(name = "starred") val starred: Boolean, //true
		@Json(name = "show-announcement") val showAnnouncement: Boolean, //false
		@Json(name = "harvest-timers-enabled") val harvestTimersEnabled: Boolean, //false
		@Json(name = "status") val status: String, //active
		@Json(name = "subStatus") val subStatus: String, //current
		@Json(name = "defaultPrivacy") val defaultPrivacy: String, //open
		@Json(name = "integrations") val integrations: Integrations,
		@Json(name = "created-on") val createdOn: String, //2017-01-03T21:49:20Z
		@Json(name = "category") val category: Category,
		@Json(name = "filesAutoNewVersion") val filesAutoNewVersion: Boolean, //false
		@Json(name = "overview-start-page") val overviewStartPage: String, //default
		@Json(name = "tags") val tags: List<Tag>,
		@Json(name = "logo") val logo: String, //https://s3.amazonaws.com/TWFiles/349705/projectLogo/tf_49AEF502-ED21-1A9D-87FAE9BD9D485267.dota22.jpg
		@Json(name = "startDate") val startDate: String, //20140405
		@Json(name = "id") val id: String, //339988
		@Json(name = "last-changed-on") val lastChangedOn: String, //2017-12-18T06:07:44Z
		@Json(name = "endDate") val endDate: String, //20261025
		@Json(name = "defaults") val defaults: Defaults,
		@Json(name = "company") val company: Company,
		@Json(name = "tasks-start-page") val tasksStartPage: String, //default
		@Json(name = "name") val name: String, //Adamantium
		@Json(name = "privacyEnabled") val privacyEnabled: Boolean, //false
		@Json(name = "description") val description: String, //Adamantium is a fictional metal alloy appearing in American comic books published by Marvel Comics. It is best known as the substance bonded to the character Wolverine's skeleton and claws. Adamantium was created by writer Roy Thomas and artists Barry Windsor-Smith and Syd Shores in Marvel Comics' Avengers #66 (July 1969), which presents the substance as part of the character Ultron's outer shell. In the stories where it appears, the defining quality of adamantium is its practical indestructibility
		@Json(name = "announcement") val announcement: String,
		@Json(name = "isProjectAdmin") val isProjectAdmin: Boolean, //true
		@Json(name = "start-page") val startPage: String, //projectoverview
		@Json(name = "notifyeveryone") val notifyeveryone: Boolean, //false
		@Json(name = "boardData") val boardData: BoardData?,
		@Json(name = "announcementHTML") val announcementHTML: String
)

data class BoardData(
        @Json(name = "name") val name: String //Cat
)

data class Company(
		@Json(name = "name") val name: String, //Cat
		@Json(name = "is-owner") val isOwner: String, //1
		@Json(name = "id") val id: String //113332
)

data class Integrations(
		@Json(name = "microsoftConnectors") val microsoftConnectors: MicrosoftConnectors,
		@Json(name = "onedrivebusiness") val onedrivebusiness: Onedrivebusiness
)

data class MicrosoftConnectors(
		@Json(name = "enabled") val enabled: Boolean //false
)

data class Onedrivebusiness(
		@Json(name = "enabled") val enabled: Boolean, //false
		@Json(name = "folder") val folder: String, //root
		@Json(name = "account") val account: String,
		@Json(name = "foldername") val foldername: String //root
)

data class Category(
		@Json(name = "name") val name: String,
		@Json(name = "id") val id: String,
		@Json(name = "color") val color: String
)

data class Defaults(
		@Json(name = "privacy") val privacy: String
)

data class Tag(
		@Json(name = "name") val name: String, //delta
		@Json(name = "id") val id: String, //56661
		@Json(name = "color") val color: String //#2f8de4
)