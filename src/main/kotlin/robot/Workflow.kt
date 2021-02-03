package robot

import io.qameta.allure.Step
import robot.MovieGuideRobots.movieListScreen

class Workflow {

    @Step("unfavorite all  Movies")
    fun unfavoriteAllMovies() {
        val count = movieListScreen.getMoviesCount()-1

        for (vi in 0..count) {
            movieListScreen
                .openFirstMovieInTheList()
                .clickOnFavorite()
                .clickBack()
        }
    }

    @Step("Favorite random movie")
    fun favoriteRandomMovie() {
        movieListScreen
            .openRandomMovie()
            .clickOnFavorite()
            .clickBack()
    }
}