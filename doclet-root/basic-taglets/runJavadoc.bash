#!/bin/bash

javadoc \
		-verbose \
    	-cp ../doclet-commons/target/doclet-commons-0.0.1-SNAPSHOT.jar:../../../../.m2/repository/org/slf4j/slf4j-api/1.8.0-beta2/slf4j-api-1.8.0-beta2.jar:/home/koldar/.m2/repository/org/slf4j/slf4j-simple/1.8.0-beta2/slf4j-simple-1.8.0-beta2.jar:/home/koldar/.m2/repository/org/apache/commons/commons-lang3/3.8.1/commons-lang3-3.8.1.jar \
    	-public \
    	-tagletpath target/basic-taglets-0.0.1-SNAPSHOT.jar:../doclet-commons/target/doclet-commons-0.0.1-SNAPSHOT.jar \
    	-taglet com.massimobono.doclets.taglets.Textbf \
    	-taglet com.massimobono.doclets.taglets.Textit \
    	-taglet com.massimobono.doclets.taglets.Date \
    	-taglet com.massimobono.doclets.taglets.Image \
    	-taglet com.massimobono.doclets.taglets.Dot \
    	-author \
    	-d doc \
    	-nodeprecated \
    	-nodeprecatedlist \
    	-noindex \
    	-nonavbar \
    	-notree \
    	-source 11 \
    	-sourcepath src/main/java:src/test/resources:src/main/resources:src/test/java \
    	-use \
    	-version \
    	com.massimobono.doclets.taglets