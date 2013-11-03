JBehave-Selendroid-Android-Automation
=====================================

<img src="http://jbehave.org/reference/preview/images/jbehave-logo.png" alt="JBehave logo" align="right" /> 

<img src="http://sauceio.com/wp-content/uploads/2011/11/selenium-logo-150x150.png" alt="Selenium logo" align="right" /> 

Android Automation with Selendroid and JBehave 

This tutorial uses JBehave 3.x,Selendroid 4.x and Selenium 2.x to test Android Native and Hybrid Applications




##Creating a Selendroid Server for the application.

Follow the below link to create the selendroid server for your test application .

http://dominikdary.github.io/selendroid/architecture.html

Install the selendroid-server.apk once build onto the device.

Resign the apk file and install the same on the device. 

##Command line start of selendroid-standalone

Go through Selendroid's setup instructions and download the current version from here(http://selendroid.io/setup.html 
The applications that are we are using in this project are located in this folder(https://github.com/selendroid/demoproject-selendroid/tree/master/src/main/resources).

java -jar selendroid-standalone-0.5.1-with-dependencies.jar -app selendroid-test-app-0.6.1.apk

## Running the stories

This will run the build and (after a minute or so) and will launch the application . 

    mvn clean install 

You should see your application  (installed on your device) flicker as it tests

This will run a single story (one contained in a PHTNhomespage.story file):

    mvn clean install -DstoryFilter=homespage

This will run a suite based on the meta filters in the three story files:

    mvn clean install -Dmeta.filter="+color red"


## Viewing the results

In directory target/jbehave/view, a page named 'reports.html' has been generated, which you open that in any browser to the stories that have run and their execution status.

There should be a row for each story.  The story reports are clickable to via links on the right-most column.

In directory target/jbehave/view, a page named 'navigator.html' has been generated, which you open that in any browser to get the story navigation

##Test Execution 

The tutorial aims to provide a fully-functional project that you can use to model you own project:

1. src/main/java/com/selendroid/jbehave/MyStories.java is the entry-point that JBehave uses to run the stories. 
2. src/main/resources contains the stories run by JBehave via MyStories.java.
3. src/main/java/com/selendroid/jbehave/steps/MySteps.java contains the steps.
4. src/main/resources/my-steps.xml contains the Spring configuration for composition the steps.

