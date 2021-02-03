package util

import framework.driver.AndroidAutomateDriver
import framework.driver.AutomateDriver
import framework.driver.IOSAutomateDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import framework.recording.AndroidScreenRecording
import framework.recording.IOSScreenRecording
import framework.recording.ScreenRecording

fun getModule(platform: Platform): Module {
    return if (platform == Platform.Android) AndroidDependencies else IOSDependencies
}

val AndroidDependencies = module {
    single<AutomateDriver> { AndroidAutomateDriver() }
    single<ScreenRecording> { AndroidScreenRecording() }
}

val IOSDependencies = module {
    single<AutomateDriver> { IOSAutomateDriver() }
    single<ScreenRecording> { IOSScreenRecording() }
}