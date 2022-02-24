data class ProjectTeam(
    val project: Project,
    val team: MutableList<Contributor> = mutableListOf()
) {
    fun toTeamNames() = team.joinToString(separator = " ") { it.name }
}