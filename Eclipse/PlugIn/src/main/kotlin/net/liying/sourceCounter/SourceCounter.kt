package net.liying.sourceCounter

import java.io.*

import net.liying.sourceCounter.parser.base.*
import net.liying.sourceCounter.parser.*

import org.antlr.v4.runtime.*

class CountResult(val file: File?, val type: String?) {
	var fileSize: Long = if (this.file != null) file.length() else 0

	var total: Int = 0

	var statement: Int = 0

	var document: Int = 0

	var comment: Int = 0

	var empty: Int = 0

	operator fun plus(b: CountResult): CountResult {
		val result = CountResult(null, null)

		result.fileSize = this.fileSize + b.fileSize
		result.total = this.total + b.total
		result.statement = this.statement + b.statement
		result.document = this.document + b.document
		result.comment = this.comment + b.comment
		result.empty = this.empty + b.empty

		return result
	}

	fun print() {
		println("""File: ${this.file?.absolutePath}
				|Type: ${this.type}
				|FileSize: ${this.fileSize}
				|Total: ${this.total}
				|Statement: ${this.statement}
				|Document: ${this.document}
				|Comment: ${this.comment}
				|Empty: ${this.empty}
				|""".trimMargin())
	}
}

class SourceCounter(val file: File, val type: String, val lexer: BaseLexer?) {
	companion object {
		const val Type_Unknown = "Unknown"
	}

	val countResult = CountResult(this.file, this.type)

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

		var preToken : WritableToken? = null
		for (token in tokenStream.tokens) {
			val currentToken = token as? WritableToken
			this.lexer.fixToken(currentToken, preToken)

			val lineCount = token.text.lines().count()
			val endLine = token.line + lineCount - 1

			maxLine = Integer.max(maxLine, endLine)
			var lineRange = token.line.rangeTo(endLine)

			when (token.type) {
				in statementTokens -> statementLines.addAll(lineRange)
				in documentTokens -> documentLines.addAll(lineRange)
				in commentTokens -> commentLines.addAll(lineRange)
			}

			preToken = currentToken
		}

		this.countResult.total = maxLine
		for (line in 1..maxLine) {
			when (line) {
				in statementLines -> this.countResult.statement++
				in documentLines -> this.countResult.document++
				in commentLines -> this.countResult.comment++
				else -> this.countResult.empty++
			}
		}
	}
}

fun buildSourceCounter(file: File, encoding: String = "UTF-8"): SourceCounter {
	val normalizedFile = file.normalize()

	val fileName = normalizedFile.name
	val extension = normalizedFile.extension

	fileTypeInfoList.forEach { fileTypeInfo ->
		val mapping = fileTypeInfo.mappingList.find { it.match(fileName, extension) }
		if (mapping != null) {
			val reader = InputStreamReader(FileInputStream(normalizedFile), encoding)
			val input = ANTLRInputStream(reader)
			val lexer = fileTypeInfo.lexerCreateFunc(input)

			return SourceCounter(normalizedFile, mapping.typeName, lexer)
		}
	}

	return SourceCounter(normalizedFile, SourceCounter.Type_Unknown, null)
}
