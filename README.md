# Appium + Kotlin (+ Allure)

Simple example for creating mobile auto tests using appium, kotlin and allure reports. 

App was taken from [here (Github)](https://github.com/Jodge/MovieGuide)

## What Do You Need (macOS)
* [install brew](https://brew.sh/)
* node: `brew install node`
* Appium: `npm install appium`
* [Appium Desktop](http://appium.io/downloads.html)
* Android SDK Tools
* Allure `npm install allure` && `npm install allure-commandline --save-dev`
* Device or emulator/simulator
* [iOS setup](http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/)

## Prepare a Device For Automation

* Enable developer options:
    * disable all animations
    * turn on usb debugging

## How To Run Tests

`./gradlew :test`

## Generate Report
`allure generate build/allure-results --clean -o allure-report`

`allure serve build/allure-results` for tmp report

## Appium Desktop Capabilities
```
{
  "platformName": "Android",
  "platformVersion": "11",
  "deviceName": "Android",
  "automationName": "UIAutomator2",
  "app": "<PATH_TO_APK>",
  "noSign": true
}
```

## Read More

* [Appium](http://appium.io/docs/en/about-appium/intro/)
* [Kotlin](https://developer.android.com/kotlin)
* [Allure](http://allure.qatools.ru/)

---

Link to presentation recording at 👉 [automateIT](https://youtu.be/MLeKeIT0wGA) channel.
