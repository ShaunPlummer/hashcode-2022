data class Contributor(val name: String, val skills: Array<Skill> = emptyArray())

data class Skill(val name: String, val level: Int)