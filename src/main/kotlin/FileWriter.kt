import java.io.File

class FileWriter(private val file: File) {

    constructor(fileName: String) : this(File(fileName))

    init {
        file.apply {
            parentFile.mkdirs()
            createNewFile()
        }
    }

    fun writeLine(line: String) {
        file.writeText("$line \n")
    }
}
