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


## Running the stories

This will run the build and (after a minute or so) and will launch the application . 

    mvn clean install 

You should see your application  (installed on your device) flicker as it tests

This will run a single story (one contained in a PHTNhomespage.story file):

    mvn clean install -DstoryFilter=PHTNhomespage

This will run a suite based on the meta filters in the three story files:

    mvn clean install -Dmeta.filter="+color red"
