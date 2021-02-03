import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import robot.MovieGuideRobots.movieListScreen
import robot.MovieGuideRobots.movieScreen
import robot.Workflow

class FirstTest : BaseTest() {

    @Test(description = "User can favorite a movie")
    fun testFavoriteAMovie() {
        movieListScreen
            .openFirstMovieInTheList()
            .clickOnFavorite()
            .clickBack()
            .clickSorting()
            .selectFavorite()
            .assertMoviesCount(1)
    }

    @Test(description = "User can favorite random movie")
    fun testFavoriteRandomMovie() {
        movieListScreen.openRandomMovie()
        val title = movieScreen.getMovieTitle()
        movieScreen
            .clickOnFavorite()
            .clickBack()
            .sortByFavorite()
            .assertMoviesCount(1)
        movieListScreen
            .openFirstMovieInTheList()
            .assertMovieTitle(title)
    }



//    @AfterMethod(description = "unfavorite all movies")
//    fun unfavoriteAllMovies() {
//        Workflow().unfavoriteAllMovies()
//    }
}