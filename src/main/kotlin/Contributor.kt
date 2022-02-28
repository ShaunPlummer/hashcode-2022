data class Contributor(val name: String, val skills: List<Skill> = emptyList()) {

    fun hasSkillAtLevel(searchSkill: String, level: Int): Boolean = findSkillAtLevel(searchSkill, level) != null

    fun findSkillAtLevel(searchSkill: String, level: Int): Skill? {
        return skills.firstOrNull { it.name == searchSkill && it.level >= level }
    }
}

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
