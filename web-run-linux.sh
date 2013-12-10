#!/bin/bash

echo "[Pre-Requirement] Makesure install JDK 6.0+ and set the JAVA_HOME."
echo "[Pre-Requirement] Makesure install Maven 3.0.3+ and set the PATH."
echo "[Pre-Requirement] Makesure install MySQL server or other Database which JPA support."
echo "[Pre-Requirement] Makesure the MySQL connection properties is correct(/framework/locus/src/main/resources/application.properties)."

set MAVEN_OPTS=$MAVEN_OPTS -XX:MaxPermSize=128m

echo "[Step 1] Install all zxy-web modules and archetype to local maven repository."
cd modules
mvn clean install -Dmaven.test.skip=true
cd ..

echo "[Step 2] Initialize schema and data for the web application."
cd framwork
mvn antrun:run -Prefres-db
cd ..

echo "[Step 3] Start the zxy-web application."
cd framework/locus
mvn clean tomcat:run &

echo "[INFO] Please wait a mement, you can access below site:"
echo "[INFO] http://localhost:9095"