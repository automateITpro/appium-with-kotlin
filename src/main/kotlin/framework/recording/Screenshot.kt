package framework.recording

import framework.driver.AutomateDriver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.openqa.selenium.*

object Screenshot: KoinComponent {

    private val automateDriver by inject<AutomateDriver>()
    fun takeScreenshot(): ScreenshotResult {

        val screenshotResult = ScreenshotResult()

        try {
            screenshotResult.screenshot = (automateDriver.driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
        } catch (e: WebDriverException) {
            screenshotResult.errorMessage = e.localizedMessage

            if (e.localizedMessage.contains("Error: read ECONNRESET")) {
                screenshotResult.driverExceptionNeedsRestart = true
            }
        }
        return screenshotResult
    }
}

class ScreenshotResult {
    var screenshot: ByteArray? = null
    var errorMessage: String? = null
    var driverExceptionNeedsRestart: Boolean = false
}
