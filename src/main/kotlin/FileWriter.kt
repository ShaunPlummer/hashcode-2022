import java.io.File

class FileWriter(private val file: File) {

    constructor(fileName: String) : this(File(fileName))

    init {
        file.apply {
            parentFile.mkdirs()
            createNewFile()
        }
    }

    fun write(teams: List<ProjectTeam>) {
        writeLine("${teams.size}")
        teams.forEach { projectTeam ->

            writeLine(projectTeam.project.name)
            projectTeam.team.forEach {
                writeLine(it.name)
            }
        }
    }

    fun writeLine(line: String) {
        file.appendText("$line \n")
    }
}
