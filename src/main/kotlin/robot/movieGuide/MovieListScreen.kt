package robot.movieGuide

import io.qameta.allure.Step
import robot.BaseRobot
import io.appium.java_client.MobileElement
import org.testng.Assert
import robot.MovieGuideRobots.filterModal
import robot.MovieGuideRobots.movieScreen
import kotlin.random.Random

class MovieListScreen: BaseRobot() {

    private val firstMovieElement: MobileElement get() = driver.findElementById("com.jodge.movies:id/poster")
    private val movieElementList: List<MobileElement> get() = driver.findElementsById("com.jodge.movies:id/container")
    private val sortElement: MobileElement get() = driver.findElementById("com.jodge.movies:id/action_sort")

    @Step("Open first movie in the list")
    fun openFirstMovieInTheList(): MovieScreen {
        firstMovieElement.click()
        return movieScreen
    }

    @Step("Click sorting")
    fun clickSorting(): FilterModal {
        sortElement.click()
        return filterModal
    }

    @Step("Open a random movie")
    fun openRandomMovie(): MovieScreen {
        val count = getMoviesCount()-1
        val randomIndex = Random.nextInt(0, count)
        movieElementList[randomIndex].click()
        return movieScreen
    }

    @Step("Get movies count")
    fun getMoviesCount(): Int {
        return movieElementList.count()
    }

    @Step("Sort by favorite")
    fun sortByFavorite(): MovieListScreen {
        clickSorting()
            .selectFavorite()
        return this
    }

    @Step("Assert movies count in the list is {count}")
    fun assertMoviesCount(count: Int): MovieListScreen {
        Assert.assertEquals(getMoviesCount(), count)
        return this
    }
}