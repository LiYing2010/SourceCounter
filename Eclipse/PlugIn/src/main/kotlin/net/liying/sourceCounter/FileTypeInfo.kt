package net.liying.sourceCounter

import net.liying.sourceCounter.parser.base.*
import net.liying.sourceCounter.parser.*

import org.antlr.v4.runtime.*

internal class FileTypeMapping(val typeName: String,
		val fileName: String?,
		val extentionList: List<String>?) {
	fun match(fileName: String, extention: String): Boolean
			= (this.fileName == fileName)
			||
				(this.extentionList != null && this.extentionList.contains(extention))
}

private fun map(typeName: String, extention: String) : FileTypeMapping
	= FileTypeMapping(typeName, null, listOf(extention))

private fun map(typeName: String, extentionList: List<String>) : FileTypeMapping
	= FileTypeMapping(typeName, null, extentionList)

private fun mapByName(typeName: String, fileName: String) : FileTypeMapping
	= FileTypeMapping(typeName, fileName, null)


internal class FileTypeInfo(val lexerCreateFunc: (input : ANTLRInputStream) -> BaseLexer?,
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

internal val fileTypeInfoList = listOf(
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
					mapByName("Make File", "makefile")),

				FileTypeInfo({input -> INILexer(input)},
					"INI", "ini")
			)
