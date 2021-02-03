package util

object EnvironmentManager {

    val isRealIosDevice: Boolean = false
    val isRemoteSeleniumGrid: Boolean = false
    val platform: Platform = Platform.Android
}

enum class Platform {
    IOS,
    Android
}