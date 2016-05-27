package net.liying.sourceCounter

import java.io.*

import net.liying.sourceCounter.parser.base.*
import net.liying.sourceCounter.parser.*

import org.antlr.v4.runtime.*

class CountResult(val file: File?, val type: String?) {
	var total: Int = 0;

	var statement: Int = 0;

	var document: Int = 0;

	var comment: Int = 0;

	var empty: Int = 0;

	operator fun plus(b: CountResult): CountResult {
		val resultType = when (this.type) {
			null,
			b.type
				-> b.type
			else
				-> ""
		}
		val result = CountResult(null, resultType)

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

fun buildSourceCounter(file: File, encoding: String = "UTF-8"): SourceCounter {
	val normalizedFile = file.normalize()

	val fileName = normalizedFile.absolutePath
	val extension = fileName.substringAfterLast('.', "").toLowerCase()

	fileTypeInfoList.forEach {
		fileTypeInfo ->
			fileTypeInfo.mappingList.forEach {
				mapping ->
					if (mapping.extentionList.contains(extension)) {
						val reader = InputStreamReader(FileInputStream(normalizedFile), encoding)
						val input = ANTLRInputStream(reader)
						val lexer = fileTypeInfo.lexerCreateFunc(input)

						return SourceCounter(normalizedFile, mapping.typeName, lexer)
					}
			}
	}

	return SourceCounter(normalizedFile, SourceCounter.Type_Unknown, null)
}

// =============================================================================
class FileTypeMapping(val typeName: String, val extentionList: List<String>) {
	constructor(typeName: String, extention: String): this(typeName, listOf(extention))
}

class FileTypeInfo(val lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
		val mappingList: List<FileTypeMapping>) {
	constructor(lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
			mapping: FileTypeMapping):
				this(lexerCreateFunc, listOf(mapping))

	constructor(lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
			typeName: String, extentionList: List<String>):
				this(lexerCreateFunc, FileTypeMapping(typeName, extentionList))

	constructor(lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
			typeName: String, extention: String):
				this(lexerCreateFunc, FileTypeMapping(typeName, extention))
}

private val fileTypeInfoList = listOf(
				FileTypeInfo({input -> KotlinLexer(input)},
					"Kotlin", "kt"),

				FileTypeInfo({input -> JavaLexer(input)},
					"Java", "java"),

				FileTypeInfo({input -> JavaScriptLexer(input)},
					"Java Script", "js"),

				FileTypeInfo({input -> CLexer(input)},
					listOf(
						FileTypeMapping("C/C++", listOf("c", "cc", "cp", "cpp", "cxx", "c++")),
						FileTypeMapping("C/C++ Header", listOf("h", "hpp")),
						FileTypeMapping("Objective-C", listOf("m", "mm"))
					)),

				FileTypeInfo({input -> XMLLexer(input)},
					listOf(
						FileTypeMapping("XML", "xml"),
						FileTypeMapping("HTML", listOf("html", "htm")),
						FileTypeMapping("XHTML", "xhtml"),
						FileTypeMapping("XSLT", listOf("xsl", "xslt")),
						FileTypeMapping("DTD", "dtd"),
						FileTypeMapping("XSD", "xsd"),
						FileTypeMapping("TLD", "tld"),
						FileTypeMapping("MXML", "mxml")
					)),

				FileTypeInfo({input -> PropertiesLexer(input)},
					"Properties", "properties"),

				FileTypeInfo({input -> CSharpLexer(input)},
					"C#", "cs"),

				FileTypeInfo({input -> CSSLexer(input)},
					"CSS", "css")
			)
