package net.liying.sourceCounter

import java.io.File

fun main(args: Array<String>) {
	if (args.size == 0) {
		println("Usage: SourceCounter pathToCount")
		return
	}

	val fileList = File(args[0]).walkTopDown().filter {
		it.isFile
	}

	for (file in fileList) {
		val sourceCounter = buildSourceCounter(file)
		sourceCounter.count()
		sourceCounter.countResult.print()

		println()
	}
}
