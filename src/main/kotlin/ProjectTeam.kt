data class ProjectTeam(
    val project: Project,
    val team: List<Contributor> = mutableListOf(),
    val teamRoles: Map<Role, Contributor>
)

fun List<Contributor>.haveSkillsFor(project: Project): MutableMap<Role, Contributor?>? {
    val roleAssignments: MutableMap<Role, Contributor?> = project.roles.associateWith { null }.toMutableMap()

    fun unfilledRoles() = roleAssignments
        .filter { (_, contributor) -> contributor == null }
        .map { it.key }

    this.sortedBy { it.skills.size }.forEach { contributor ->
        val role = unfilledRoles()
            .sortedBy { it.level }
            .reversed()
            .firstOrNull {
                contributor.skills.contains(it.skillName)
            }
        if (role != null) roleAssignments[role] = contributor
    }
    return roleAssignments.takeIf { unfilledRoles().isEmpty() }
}