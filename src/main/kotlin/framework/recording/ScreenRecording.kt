package framework.recording

import framework.driver.AutomateDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSStartScreenRecordingOptions
import io.qameta.allure.Step
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.openqa.selenium.WebDriverException
import java.util.*

interface ScreenRecording {

    @Step("Start recording")
    fun startRecording()
    fun stopRecording(): ByteArray?
}


abstract class BaseScreenRecording: KoinComponent, ScreenRecording {
    protected val automateDriver by inject<AutomateDriver>()

    protected fun ignoreWebDriverException(block: () -> Unit) {
        try {
            block()
        } catch (e: WebDriverException) {}
    }

    protected fun stopRecordingIgnoreWebDriverException(block: () -> ByteArray?) : ByteArray? {
        return try {
            block()
        } catch (e: WebDriverException) {
            null
        }
    }
}

class AndroidScreenRecording: BaseScreenRecording() {

    private val android: AndroidDriver<MobileElement> get() = automateDriver.driver as AndroidDriver<MobileElement>

    override fun startRecording() {
        ignoreWebDriverException {
            android.startRecordingScreen()
        }
    }

    override fun stopRecording(): ByteArray? {
        return stopRecordingIgnoreWebDriverException {
            Base64.getDecoder().decode(android.stopRecordingScreen())
        }
    }
}
class IOSScreenRecording: BaseScreenRecording() {
    private val iOS: IOSDriver<MobileElement> get() = automateDriver.driver as IOSDriver<MobileElement>

    override fun startRecording() {
        ignoreWebDriverException {
            iOS.startRecordingScreen(IOSStartScreenRecordingOptions().withVideoType("libx264"))
        }
    }

    override fun stopRecording(): ByteArray? {
        return stopRecordingIgnoreWebDriverException {
            Base64.getDecoder().decode(iOS.stopRecordingScreen())
        }
    }
}