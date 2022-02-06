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
    FileReader(file).apply {
        println("Header: $header")
        reader.lines().forEach {
            println(it)
        }
    }

    // val outputFile = FileWriter("out/${file.name}")
    // outputFile.writeLine(it)
}
