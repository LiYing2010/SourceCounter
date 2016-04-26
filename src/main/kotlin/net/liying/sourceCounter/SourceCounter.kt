package net.liying.sourceCounter

import net.liying.sourceCounter.parser.base.*
import net.liying.sourceCounter.parser.*

import org.antlr.v4.runtime.*

class CountResult(val fileName: String, val type: String) {
	var total: Int = 0;

	var statement: Int = 0;

	var document: Int = 0;

	var comment: Int = 0;

	var empty: Int = 0;

	fun print() {
		println("""File: ${this.fileName}
				|Type: ${this.type}
				|Total: ${this.total}
				|Statement: ${this.statement}
				|Document: ${this.document}
				|Comment: ${this.comment}
				|Empty: ${this.empty}
				|""".trimMargin())
	}
}

class SourceCounter(val fileName: String, val type: String, val lexer: BaseLexer?) {
	val countResult = CountResult(this.fileName, this.type)

	fun count() {
		if (this.lexer == null) {
			return
		}

		val statementTokens = this.lexer.statementTokens
		val documentTokens = this.lexer.documentTokens
		val commentTokens = this.lexer.commentTokens

		val statementLines = mutableSetOf<Int>()
		val documentLines = mutableSetOf<Int>()
		val commentLines = mutableSetOf<Int>()

		var maxLine = 0

		val tokenStream = CommonTokenStream(this.lexer)

		tokenStream.fill()
		for (token in tokenStream.tokens) {
			val lineCount = token.text.lines().count()
			val endLine = token.line + lineCount - 1

			maxLine = Integer.max(maxLine, endLine)
			var lineRange = token.line.rangeTo(endLine)

			when (token.type) {
				in statementTokens
					-> statementLines.addAll(lineRange)

				in documentTokens
					-> documentLines.addAll(lineRange)

				in commentTokens
					-> commentLines.addAll(lineRange)
			}
		}

		this.countResult.total = maxLine
		for (line in 1..maxLine) {
			when (line) {
				in statementLines
					-> this.countResult.statement++

				in documentLines
					-> this.countResult.document++

				in commentLines
					-> this.countResult.comment++

				else
					-> this.countResult.empty++
			}
		}
	}
}


fun buildSourceCounter(fileName: String): SourceCounter {
	val input = ANTLRFileStream(fileName)

	val ext = fileName.substringAfterLast('.', "").toLowerCase()

	return when (ext) {
		"java"
			-> SourceCounter(fileName, "Java", JavaLexer(input))

		"kt"
			-> SourceCounter(fileName, "Kotlin", KotlinLexer(input))

		else
			-> SourceCounter(fileName, "Unknown", null)
	}
}


