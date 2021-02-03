package robot.movieGuide

import robot.BaseRobot
import io.appium.java_client.MobileElement
import io.qameta.allure.Step
import robot.MovieGuideRobots.movieListScreen

class FilterModal: BaseRobot() {
    private val favoritesSelection: MobileElement get() = driver.findElementById("com.jodge.movies:id/favorites")

    @Step("Select sorting by favorite")
    fun selectFavorite(): MovieListScreen {
        favoritesSelection.click()
        return movieListScreen
    }
}



