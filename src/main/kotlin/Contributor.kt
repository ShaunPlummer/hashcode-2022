data class Contributor(val name: String, val skills: Array<Skill> = emptyArray())

data class Skill(val name: String, val level: Int)

data class Project(val name: String, val daysToComplete:Int, val score:Int, val bestBeforeDay: Int, val numOfRoles:Int)