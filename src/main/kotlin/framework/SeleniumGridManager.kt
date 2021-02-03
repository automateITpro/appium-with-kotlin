package framework

import util.EnvironmentManager.isRemoteSeleniumGrid

object SeleniumGridManager {
    val serverAddress = if (isRemoteSeleniumGrid) "<IP>:<PORT>/wd/hub" else "http://127.0.0.1:4723/wd/hub"
}