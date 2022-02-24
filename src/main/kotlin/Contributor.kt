import java.lang.Integer.max
import kotlin.math.min

data class Contributor(val name: String, val skills: List<Skill> = emptyList()) {

    fun hasSkill(searchSkill: String, level: Int): Boolean = findSkillAtOrBelow(searchSkill, level) != null

    fun findSkillAtOrBelow(searchSkill: String, level: Int): Skill? {
        return skills.firstOrNull { it.name == searchSkill && it.level == level || it.level == level -1 }
    }

}

data class Skill(val name: String, var level: Int)

data class Project(
    val name: String,
    val daysToComplete: Int,
    val score: Int,
    val bestBeforeDay: Int,
    val numOfRoles: Int,
    val roles: List<Role>
) {
    fun score(currentDay: Int) = max(0, score + min(0, bestBeforeDay - (currentDay + daysToComplete)))
}

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

