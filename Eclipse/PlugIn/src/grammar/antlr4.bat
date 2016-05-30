@echo off
set TOP_DIR=..\..
set CLASSPATH=%TOP_DIR%\lib\antlr-4.5.3-complete.jar
set OUT_DIR=%TOP_DIR%\src\main\java\parser\net\liying\sourceCounter\parser

java -cp %CLASSPATH% org.antlr.v4.Tool -o %OUT_DIR% %*
