package robot.movieGuide

import io.appium.java_client.MobileElement
import io.qameta.allure.Step
import org.testng.Assert
import robot.BaseRobot
import robot.MovieGuideRobots.movieListScreen

class MovieScreen: BaseRobot() {
    private val nameElement: MobileElement get() = driver.findElementById("com.jodge.movies:id/movie_name")
    private val favoriteButton: MobileElement get() = driver.findElementById("com.jodge.movies:id/favorite")
    private val backButton: MobileElement get() = driver.findElementByAccessibilityId("Navigate up")

    @Step("Get movie name")
    fun getMovieTitle(): String {
        return nameElement.text
    }

    @Step("Click on favorite")
    fun clickOnFavorite(): MovieScreen {
        favoriteButton.click()
        return this
    }

    @Step("Get back to movie list")
    fun clickBack(): MovieListScreen {
        backButton.click()
        return movieListScreen
    }

    @Step("Assert movie title is {title}")
    fun assertMovieTitle(title: String) {
        Assert.assertEquals(getMovieTitle(), title, "Movie titles are not the same")
    }
}


//MobileElement el1 = (MobileElement) driver.findElementById("com.jodge.movies:id/movie_name");
//el1.click();
//MobileElement el2 = (MobileElement) driver.findElementById("com.jodge.movies:id/favorite");
//el2.click();
//MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
//el3.click();