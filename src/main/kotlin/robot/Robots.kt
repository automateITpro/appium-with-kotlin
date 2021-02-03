package robot

import robot.movieGuide.FilterModal
import robot.movieGuide.MovieListScreen
import robot.movieGuide.MovieScreen

object MovieGuideRobots {
    val movieListScreen: MovieListScreen get() = MovieListScreen()
    val filterModal: FilterModal get() = FilterModal()
    val movieScreen: MovieScreen get() = MovieScreen()
}