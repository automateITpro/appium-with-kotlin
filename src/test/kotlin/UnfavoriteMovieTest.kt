import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import robot.MovieGuideRobots.movieListScreen
import robot.Workflow

class UnfavoriteMovieTest: BaseTest() {

    @BeforeMethod(description = "favorite any movie")
    fun favoriteAnyMovie() {
        Workflow().favoriteRandomMovie()
    }

    @Test(description = "User can unfavorite movie and list should refresh")
    fun unfavoriteMovieAndListRefresh() {
        movieListScreen
            .sortByFavorite()
            .assertMoviesCount(1)
            .openFirstMovieInTheList()
            .clickOnFavorite()
            .clickBack()
            .assertMoviesCount(0)
    }
}