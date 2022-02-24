data class Contributor(val name: String, val skills: List<Skill> = emptyList()) {

    fun hasSkill(searchSkill: String, level: Int): Boolean = findSkillAtOrBelow(searchSkill, level) != null

    fun findSkillAtOrBelow(searchSkill: String, level: Int): Skill? {
        return skills.firstOrNull { it.name == searchSkill && it.level == level || it.level == level -1 }
    }

}

data class Skill(val name: String, val level: Int)

data class Project(
    val name: String,
    val daysToComplete: Int,
    val score: Int,
    val bestBeforeDay: Int,
    val numOfRoles: Int,
    val roles: List<Role>
)

data class Role(val skillName: String, val level: Int)

fun List<Contributor>.teamSkills(): MutableMap<String, Int> {
    val skills = mutableMapOf<String, Int>()
    forEach { contributor ->
        contributor.skills.forEach { skill ->
            val oldLevel = skills.getOrPut(skill.name) {
                skill.level
            }
            if (oldLevel < skill.level) {
                skills[skill.name] = skill.level
            }
        }
    }
    return skills
}

fun List<Contributor>.haveSkills(project: Project): Boolean {
    return project.roles.all { role ->
        teamSkills().getOrDefault(role.skillName, 0) >= role.level
    }
}