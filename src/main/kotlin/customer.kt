data class Customer(
    val likes: Array<String>,
    var dislikes: Array<String> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (!likes.contentEquals(other.likes)) return false
        if (!dislikes.contentEquals(other.dislikes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = likes.contentHashCode()
        result = 31 * result + dislikes.contentHashCode()
        return result
    }
}