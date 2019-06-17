## Gradle for Android and Java Final Project

In this project, I created an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

![Screen](https://lh3.googleusercontent.com/cJQtO_A08shKWZ1NEJxpvdYcfXxoHH87HYldIx_gOoGcoqnnZDTP3ycVqAnZSUMYzHygxhb-nEE_Yv_QmZY=s0)

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What Did I Learn?

I learnt the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. I learnt to:

* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

## How Did I Complete this Project?

### Step 0: Starting Point

This is the starting point for the final project, which is provided to me in
the [course repository](https://github.com/udacity/ud867/tree/master/FinalProject). It
contains an activity with a banner ad and a button that purports to tell a
joke, but actually just complains. The banner ad was set up following the
instructions here:

https://developers.google.com/mobile-ads-sdk/docs/admob/android/quick-start

(You may need to download the Google Repository from the Extras section of the
Android SDK Manager.)

### Step 1: Created a Java library

My first task was to create a Java library that provides jokes. Create a new
Gradle Java project either using the Android Studio wizard, or by hand. Then
introduce a project dependency between my app and the new Java Library.

I made the button display a toast showing a joke retrieved from your Java joke
telling library.

### Step 2: Created an Android Library

Created an Android Library containing an Activity that displays a joke
passed to it as an intent extra. Wired up project dependencies so that the
button can passes the joke from the Java Library to the Android Library.

### Step 3: Created GCE Module

This next task was be pretty tricky. Instead of pulling jokes directly from
our Java library, I had to set up a Google Cloud Endpoints development server,
and pull our jokes from there. 

(I followed instructions from here: https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints)

I introduced a project dependency between the Java library and the GCE module,
and modifid the GCE starter code to pull jokes from the Java library. Then I created
an Async task to retrieve jokes. Made the button kick off a task to retrieve a
joke, then launch the activity from your Android Library to display it.

### Step 4: Added Functional Tests

Added code to test that your Async task successfully retrieves a non-empty
string.

### Step 5: Added a Paid Flavor

Added free and paid product flavors to your app. Removed the ad (and any other irrelevant 
dependencies) from the paid flavor.

### Configured Test Task

To tie it all together, I create a Gradle task that:

1. Launches the GCE local development server
2. Runs all tests
3. Shuts the server down again

# Rubric

### Required Components

- [x] Project contains a Java library for supplying jokes
- [X] Project contains an Android library with an activity that displays jokes passed to it as intent extras.
- [x] Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
- [x] Project contains connected tests to verify that the async task is indeed loading jokes.
- [x] Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

### Required Behavior

- [x] App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
