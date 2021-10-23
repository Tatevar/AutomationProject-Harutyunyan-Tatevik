# AutomationProject-Harutyunyan-Tatevik-
Automation Project
_Maven commands_
**Command**
**mvn versions:display-dependency-updates**

The following dependencies in Dependencies have newer versions:
[INFO]   com.codeborne:selenide ............... 5.25.0 -> 5.25.0-selenium-4.0.0
[INFO]   com.fasterxml.jackson.dataformat:jackson-dataformat-xml ...
[INFO]                                                         2.11.1 -> 2.13.0
[INFO]   com.fasterxml.jackson.dataformat:jackson-dataformat-yaml ...
[INFO]                                                         2.12.5 -> 2.13.0
[INFO]   io.qameta.allure:allure-testng ...................... 2.14.0 -> 2.15.0
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0
[INFO]
[INFO] artifact org.aspectj:aspectjweaver: checking for updates from central
[INFO] The following dependencies in Plugin Dependencies have newer versions:
[INFO]   org.aspectj:aspectjweaver ......................... 1.9.6 -> 1.9.8.RC1
**Command**
**mvn versions:use-latest-versions**
[INFO] --- versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ AutomationProject-Harutyunyan-Tatevik ---
[INFO] Major version changes allowed
[INFO] Updated com.fasterxml.jackson.dataformat:jackson-dataformat-xml:jar:2.11.1 to version 2.13.0
[INFO] Updated io.qameta.allure:allure-testng:jar:2.14.0 to version 2.15.0
[INFO] Updated com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.12.5 to version 2.13.0

**Command**
**mvn clean test -Dsuite="src/test/resources/Lecture_18.xml"**
[INFO]
[ERROR] Tests run: 5, Failures: 1, Errors: 0, Skipped: 0

**Command**
**mvn clean -Dtest=MoodPanda_Test#verifyHomePage_Test -DTestMvn=1**
[INFO] BUILD SUCCESS
test class- MoodPanda_Test
Test- verifyHomePage_Test
Property-TestMvn
