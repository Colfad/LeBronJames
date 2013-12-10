@echo off
echo [Pre-Requirement] Makesure install JDK 6.0+ and set JAVA_HOME.
echo [Pre-Requirement] Makesure install Maven 3.0.3+ and set the PATH.
echo [Pre-Requirement] Makesure install MySQL server or other Database which JPA support.
echo [Pre-Requirement] Makesure the MySQL connection properties is correct(/framework/locus/src/main/resources/application.properties).

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

echo [Step 1] Install all zxy-web modules and archetype to local maven repository.
cd modules
call %MVN% clean install -Dmaven.test.skip=true
if errorlevel 1 goto error
cd ..

echo [Step 2] Initialize schema and data for the web application.
cd framework
call %MVN% antrun:run -Prefresh-db
if errorlevel 1 goto error
cd ..

echo [Step 3] Start the zxy-web application.
cd 	framework\locus
start "Locus" %MVN% clean tomcat:run
if errorlevel 1 goto error
cd ..\..\

echo [INFO] Please wait a mement. When you see "[INFO] Started Tomcat Server" console, you can access below site:
echo [INFO] http://localhost:9095

goto end
:error
echo Error Happen!!
:end
pause 