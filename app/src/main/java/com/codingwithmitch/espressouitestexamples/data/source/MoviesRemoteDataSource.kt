package com.codingwithmitch.espressouitestexamples.data.source

import com.codingwithmitch.espressouitestexamples.data.FakeMovieData
import com.codingwithmitch.espressouitestexamples.data.Movie

class MoviesRemoteDataSource: MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(FakeMovieData.movies.size)

    init {
        for (movie in FakeMovieData.movies){
            addMovie(movie)
        }
    }

    override fun getMovies(): List<Movie> {
        return ArrayList(MOVIES_REMOTE_DATA.values)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(
        id: Int,
        title: String,
        image: String,
        description: String,
        directors: ArrayList<String>?,
        star_actors: ArrayList<String>?
    ){
        val movie = Movie(
            id = id,
            title = title,
            image = image,
            description = description,
            directors = directors,
            star_actors = star_actors
        )
        MOVIES_REMOTE_DATA.put(id, movie)
    }


    private fun addMovie(
        movie: Movie
    ){
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }

}














