package framework.driver

import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import util.App
import util.EnvironmentManager.isRealIosDevice

object Capabilities {

//    private val permissions =
//        "{\"${<bundleID>}\": {\"notifications\": \"YES\",\"camera\": \"YES\",\"location\": \"always\",\"medialibrary\": \"YES\",\"photos\": \"YES\"}}"

    fun Android(): DesiredCapabilities {
        val capabilities = createCommonCapabilities()

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300)
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, true)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2")
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
        capabilities.setCapability("appium:enforceAppInstall", true)

        return capabilities
    }

    fun iOS() : DesiredCapabilities {
        val capabilities = createCommonCapabilities()

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.2")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false)
        capabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, "false")
//        capabilities.setCapability("appium:permissions", permissions)
        capabilities.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, "true")
        capabilities.setCapability("appium:waitForQuiescence", "false")
        capabilities.setCapability(IOSMobileCapabilityType.MAX_TYPING_FREQUENCY, 10)

        if (isRealIosDevice) {
            capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "<ID>")
            capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "<SIGN ID>")
            capabilities.setCapability(MobileCapabilityType.UDID, "<PHONE UDID>")
          //  capabilities.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, portal.appPackage.ios)
        }
        return capabilities
    }

    private fun createCommonCapabilities(): DesiredCapabilities {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.APP, App.Path)
        return capabilities
    }
}