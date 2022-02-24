data class ProjectTeam(
    val project: Project,
    val team: MutableList<Contributor> = mutableListOf(),
    val teamRoles: Map<Role, Contributor>? = null
)

fun List<Contributor>.haveSkillsFor(project: Project): MutableMap<Role, Contributor?>? {
    val roleAssignments: MutableMap<Role, Contributor?> = project.roles.associateWith { null }.toMutableMap()

    fun unfilledRoles() = roleAssignments
        .filter { (_, contributor) -> contributor == null }
        .keys

    this.sortedBy { it.skills.size }.forEach { contributor ->
        val role = unfilledRoles()
            .sortedBy { it.level }
            .reversed()
            .firstOrNull { role ->
                contributor.canFillRole(role)
            }
        if (role != null) roleAssignments[role] = contributor
    }
    val ret = roleAssignments.takeIf { unfilledRoles().isEmpty() }
    return ret
}

fun Contributor.canFillRole(role: Role): Boolean {
    return skills.any { skill ->
        skill.name == role.skillName && skill.level >= role.level
    }
}