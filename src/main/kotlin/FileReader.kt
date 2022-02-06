import java.io.BufferedReader
import java.io.File

class FileReader(file: File) {
    val header: List<Int>
    val reader: BufferedReader

    init {
        if (!file.isFile) {
            println("Error: expected a file")
        }
        reader = file.bufferedReader()
        header = reader.readLine()
            .split(" ")
            .filterNot { it.isBlank() }
            .map { it.toInt() }
    }
}
