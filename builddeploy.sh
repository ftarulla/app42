#!/bin/bash

./gradlew --daemon assembleDebug &&
adb install -r app/build/outputs/apk/app-debug.apk &&
adb shell am start -n com.example.ftarulla.myapplication42/com.example.ftarulla.myapplication42.TaskListActivity
