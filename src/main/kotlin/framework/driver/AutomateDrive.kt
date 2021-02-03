package framework.driver

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import framework.SeleniumGridManager
import java.net.URL
import java.util.concurrent.TimeUnit

interface AutomateDriver {
    var driver:AppiumDriver<MobileElement>
    fun initDriver()

    fun findElementById(id: String): MobileElement
    fun findElementByAccessibilityId(id: String): MobileElement

    fun findElementsById(id: String): List<MobileElement>
}

abstract class BaseAutomateDriver: AutomateDriver {
    override var driver: AppiumDriver<MobileElement> by ThreadLocalDelegate.lateinit()

    override fun findElementByAccessibilityId(id: String): MobileElement {
        return driver.findElementByAccessibilityId(id)
    }

    protected fun setImplicityWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }
}

class AndroidAutomateDriver: BaseAutomateDriver() {

    override fun initDriver() {
        driver = AndroidDriver(URL(SeleniumGridManager.serverAddress), Capabilities.Android())
        setImplicityWait()
    }

    override fun findElementById(id: String): MobileElement {
        return driver.findElementById(id)
    }

    override fun findElementsById(id: String): List<MobileElement> {
        return driver.findElementsById(id)
    }
}

class IOSAutomateDriver: BaseAutomateDriver() {
    override fun initDriver() {
        driver = IOSDriver(URL(SeleniumGridManager.serverAddress), Capabilities.iOS())
        setImplicityWait()
    }

    override fun findElementById(id: String): MobileElement {
        return driver.findElementByAccessibilityId(id)
    }

    override fun findElementsById(id: String): List<MobileElement> {
        return driver.findElementsByAccessibilityId(id)
    }
}