import java.io.File

class FileWriter(private val file: File) {

    constructor(fileName: String) : this(File(fileName))

    init {
        file.apply {
            parentFile.mkdirs()
            createNewFile()
            file.delete()
        }
    }

    fun write(teams: List<ProjectTeam>) {
        writeLine("${teams.size}")
        teams.forEach { projectTeam ->

            writeLine(projectTeam.project.name)
            writeLine(projectTeam.toTeamNames())
        }
    }

    fun writeLine(line: String) {
        file.appendText("$line \n")
    }
}
