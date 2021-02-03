package framework.reporting

import com.github.automatedowl.tools.AllureEnvironmentWriter
import com.google.common.collect.ImmutableMap
import io.qameta.allure.Attachment
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import util.EnvironmentManager.platform
import framework.recording.Screenshot
import framework.recording.ScreenRecording

object AllureReport: KoinComponent {
        private val screenRecording by inject<ScreenRecording>()

        fun setEnvironment() {
            AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.builder<String, String>()
                    .put("Platform", "$platform")
                    .build(), System.getProperty("user.dir") + "/build/allure-results/"
            )
        }

        @Attachment("screenshot", type = "image/png")
        fun addScreenshot(): ByteArray? {
            return Screenshot.takeScreenshot().screenshot
        }

        @Attachment("Video", type = "video/mp4")
        fun stopRecording(): ByteArray? {
            return screenRecording.stopRecording()
        }
}
