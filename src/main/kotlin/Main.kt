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

        val customerList = mutableListOf<Customer>()

        var tmpCustomer: Customer? = null
        reader.lines().forEach {
            println("Line: $it")
            if (tmpCustomer == null) {
                tmpCustomer = Customer(
                    it.toToppingListList()
                )
            } else if (tmpCustomer != null) {
                tmpCustomer!!.dislikes = it.toToppingListList()

                customerList.add(tmpCustomer!!)
                tmpCustomer = null
            }
        }

        val likesList = mutableListOf<String>()
        val dislikesList = mutableListOf<String>()
        customerList.forEach { customer ->
            customer.likes.forEach {
                likesList.add(it)
            }
            customer.dislikes.forEach {
                dislikesList.add(it)
            }
        }

        println("customers: ${customerList.size} list: $customerList")
        println("likes: $likesList")
        println("dislikes: $dislikesList")

        likesList.removeAll {
            dislikesList.contains(it)
        }

        println("unanimousToppings: $likesList")

        val outputFile = FileWriter("out/${file.name}")
        outputFile.writeLine("${likesList.size} $likesList")
    }
}

fun String.toToppingListList(): Array<String> {
    val parts = split(" ")
    return if (parts[0].toInt() == 0) {
        emptyArray()
    } else {
        parts.subList(1, parts.size).toTypedArray()
    }
}
