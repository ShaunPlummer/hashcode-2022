data class ProjectTeam(
    val project: Project,
    val team: MutableList<Contributor> = mutableListOf()
)