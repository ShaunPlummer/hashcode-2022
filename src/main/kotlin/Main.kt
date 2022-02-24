import java.io.BufferedReader
import java.io.File


/**
 * Main entry point, accepting a directory containing the input files.
 */
fun main(args: Array<String>) {
    File(args.first())
        .listFiles()
        ?.filterNot { it.name == ".gitignore" }
        ?.forEach(::processFile)
}

private fun processFile(file: File) {
    println("checking file: ${file.name}")
    val fr = FileReader(file)
    val (contributorCount, projectCount) = fr.header.toList()
    val contributors = List(contributorCount.toInt()) {
        fr.reader.getContributor()
    }
    println(contributors)
    val projects = List(projectCount.toInt()) {
        fr.reader.getProject()
    }
    println(projects)
    println("team skills: ${contributors.teamSkills()}")

    projects.forEach { project ->
        println("project: ${project.name}, team can do: ${contributors.haveSkills(project)}")
    }

    // val outputFile = FileWriter("out/${file.name}")
    // outputFile.writeLine(it)


}

fun BufferedReader.getContributor(): Contributor {
    val (name, skillCount) = readLine()!!.split(" ").toList()
    println("name: $name, skillcount: $skillCount")
    val skills = List(skillCount.toInt()) {
        this.getSkill()
    }
    return Contributor(name, skills)
}

fun BufferedReader.getSkill(): Skill {
    val (name, level) = readLine()!!.split(" ").toList()
    return Skill(name, level.toInt())
}

fun BufferedReader.getProject(): Project {
    val (name, daysToComplete, score, bestBeforeDay, numOfRoles) = readLine().split(" ")
    return Project(
        name = name,
        daysToComplete = daysToComplete.toInt(),
        score = score.toInt(),
        bestBeforeDay = bestBeforeDay.toInt(),
        numOfRoles = numOfRoles.toInt(),
        roles = List(numOfRoles.toInt()) {
            getRole()
        }
    )
}

fun BufferedReader.getRole(): Role {
    val (skillName, level) = readLine().split(" ")
    return Role(skillName, level.toInt())
}
