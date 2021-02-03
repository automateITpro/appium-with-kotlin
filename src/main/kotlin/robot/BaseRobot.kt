package robot

import framework.driver.AutomateDriver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseRobot: KoinComponent {
    val driver by inject<AutomateDriver>()
}