# QMHomeworkWikia
QMHomeworkWikia is a Pre-Interview Homework Wikia 2015 for Tan Su as a job candidate of QM Engineer, that enables automation of web browsers of Chrome and Firefox. The tests are written in Selenium WebDriver with Java/TestNG/Maven framework, the project is built in PageOjects pattern, which can be followed at https://code.google.com/p/selenium/wiki/PageObjects

The exercise contains two testing scenarios at https://docs.google.com/document/d/1GA25KBGtg3g3hDhUxBRWpC_RknC1KehyELXGqjG1p5M/edit#

SCENARIO 1 - LOGIN,
SCENARIO 2 - ADD VIDEO

## Repositories

The master repository of selenium test is at https://github.com/tansu2/QMHomeworkWikia.git

## Pull requests

The project accept public pull requests from GitHub.  
To download the project in your local repo, do...

	git clone https://github.com/tansu2/QMHomeworkWikia.git
	cd QMHomeworkWikia

## Building

The project uses maven build system, so all the tests go in the *src/test/java* folder with package name **test**. 
Tests should inherit from the **CommonTest** class. This class contains *beforeClass* and *afterClass* method
that is in charge of generating the instance of the WebDriver interface, closing the instance of the WebDriver interface and loading parameters you need. Different parameters are passed into the factory:

* base URL : base URL of the AUT (application under test)
* home page URL: URL of the base URL automatically redirects to
* username / password : the precondition of having previously created an account and user name for Wikia.com
* etc.

Those parameters are retrieved from the *src/main/resources/config/property_file_name.properties* files. You can populate the properties file from command line (through **-Denv=property_file_name** in mvn command or through Jenkins).

To build this project with Chrome driver, in the same directory as this file, do…

	mvn test -Denv=chrome
	
This will first load default.properties file then load customized chrome.properties file
	
To build this project with firefox driver, in the same directory as this file, do…

	mvn test -Denv=firefox

This will first load default.properties file then load customized firefox.properties file

In any case, default.properties will always be loaded first. More customized properties files can be added.
Once the parameters are loaded, the tests will run and if any errors/exceptions occur, the error messages will be
logged and the screenshots will be taken and stored at */screenshots* folder.

## Report
Report is stored under */target/surefire-reports/Command line suite*
HTTP Traffic information is printed out to console via all communication process with server.

## Requirements

* [Java 6 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* `java` and `jar` on the PATH

Note that all Selenium Java artifacts are **built with Java 6 (mandatory)**.  Those _will work with any Java >= 6_.

In order to use firefoxdriver, firefox browser is required to be installed.
Support for Firefox is the latest release, the previous release, the latest ESR release and the previous ESR release.

For example Selenium 2.40.0 (released on Feb 19, 2014) supports Firefox 27, 26, 24, 17

Selenium with Firefox can be run on any platform that Firefox supports for those versions, that also allow users to install a custom Firefox extension.

This project uses Firefox 27.0 as the browser

Adding Chrome Driver to the project
-----------------------------------
If you need to use chromedriver, you should put the proper driver file downloaded from http://code.google.com/p/chromium/downloads/list into *src/main/resources/driver/chrome*. 
If you are on Windows, the file should be named *chromedriver.exe*,
if on Unix-based system, the file should be named *chromedriver*.

TestNG
------
For more info around TestNG framework, go to http://testng.org/doc/index.html. If you prefer, you could substitute this framework with JUnit.


Page Object pattern
-------------------
For more info around this pattern, read this wiki page: http://code.google.com/p/selenium/wiki/PageObjects
