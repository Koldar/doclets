#!/bin/bash

javadoc \
		-verbose \
    	-cp ../doclet-commons/target/doclet-commons-0.0.1-SNAPSHOT.jar \
    	-public \
    	-tagletpath target/basic-taglets-0.0.1-SNAPSHOT.jar:../doclet-commons/target/doclet-commons-0.0.1-SNAPSHOT.jar \
    	-taglet com.massimobono.doclets.taglets.Textbf \
    	-taglet com.massimobono.doclets.taglets.Textit \
    	-taglet com.massimobono.doclets.taglets.Date \
    	-taglet com.massimobono.doclets.taglets.Image \
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