#!/bin/bash

build() {
   ./gradlew --daemon assembleDebug &&
   adb install -r app/build/outputs/apk/app-debug.apk
}

deploy() {
   adb shell am start -n com.example.ftarulla.myapplication42/com.example.ftarulla.myapplication42.MainActivity
}


while true
do
   
   inotifywait -r -e modify,attrib,close_write,move,create,delete ./app/src && 
      build && 
      deploy

done
