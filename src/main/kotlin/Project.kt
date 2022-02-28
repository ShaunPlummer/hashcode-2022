import kotlin.math.min

data class Project(
    val name: String,
    val daysToComplete: Int,
    val score: Int,
    val bestBeforeDay: Int,
    val numOfRoles: Int,
    val roles: List<Role>
) {
    fun score(currentDay: Int) = Integer.max(0, score + min(0, bestBeforeDay - (currentDay + daysToComplete)))
}
