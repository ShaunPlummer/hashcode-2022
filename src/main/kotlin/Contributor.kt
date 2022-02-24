data class Contributor(val name: String, val skills: List<Skill> = emptyList())

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