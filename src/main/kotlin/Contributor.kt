data class Contributor(val name: String, val skills: List<Skill> = emptyList())

data class Skill(val name: String, val level: Int)