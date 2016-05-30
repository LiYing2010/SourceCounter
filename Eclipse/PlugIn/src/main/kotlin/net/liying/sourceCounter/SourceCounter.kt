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

	val fileName = normalizedFile.name
	val extension = normalizedFile.extension

	fileTypeInfoList.forEach {
		fileTypeInfo ->
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

// =============================================================================
class FileTypeMapping(val typeName: String,
		val fileName: String?,
		val extentionList: List<String>?) {
	fun match(fileName: String, extention: String): Boolean
			= (this.fileName == fileName)
			||
				(this.extentionList != null && this.extentionList.contains(extention))
}

fun map(typeName: String, extention: String) : FileTypeMapping
	= FileTypeMapping(typeName, null, listOf(extention))

fun map(typeName: String, extentionList: List<String>) : FileTypeMapping
	= FileTypeMapping(typeName, null, extentionList)

fun mapByName(typeName: String, fileName: String) : FileTypeMapping
	= FileTypeMapping(typeName, fileName, null)

class FileTypeInfo(val lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
		val mappingList: List<FileTypeMapping>) {
	constructor(lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
			mapping: FileTypeMapping):
				this(lexerCreateFunc, listOf(mapping))

	constructor(lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
			typeName: String, extentionList: List<String>):
				this(lexerCreateFunc, map(typeName, extentionList))

	constructor(lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
			typeName: String, extention: String):
				this(lexerCreateFunc, map(typeName, extention))
}

// =============================================================================

private val fileTypeInfoList = listOf(
				FileTypeInfo({input -> KotlinLexer(input)},
					"Kotlin", "kt"),

				FileTypeInfo({input -> JavaLexer(input)},
					"Java", "java"),

				FileTypeInfo({input -> JavaScriptLexer(input)},
					"Java Script", "js"),

				FileTypeInfo({input -> CLexer(input)},
					listOf(
						map("C/C++", listOf("c", "cc", "cp", "cpp", "cxx", "c++")),
						map("C/C++ Header", listOf("h", "hpp")),
						map("Objective-C", listOf("m", "mm"))
					)),

				FileTypeInfo({input -> XMLLexer(input)},
					listOf(
						map("XML", "xml"),
						map("HTML", listOf("html", "htm")),
						map("XHTML", "xhtml"),
						map("XSLT", listOf("xsl", "xslt")),
						map("DTD", "dtd"),
						map("XSD", "xsd"),
						map("TLD", "tld"),
						map("MXML", "mxml")
					)),

				FileTypeInfo({input -> PropertiesLexer(input)},
					"Properties", "properties"),

				FileTypeInfo({input -> CSharpLexer(input)},
					"C#", "cs"),

				FileTypeInfo({input -> CSSLexer(input)},
					"CSS", "css"),

				FileTypeInfo({input -> SQLLexer(input)},
					"SQL", "sql"),

				FileTypeInfo({input -> JSONLexer(input)},
					"JSON", "json"),

				FileTypeInfo({input -> YAMLLexer(input)},
					"YAML", listOf("yaml", "yml")),

				FileTypeInfo({input -> ShellLexer(input)},
					"Shell Script", "sh"),

				FileTypeInfo({input -> MakeFileLexer(input)},
					mapByName("Make File", "makefile"))
			)
