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