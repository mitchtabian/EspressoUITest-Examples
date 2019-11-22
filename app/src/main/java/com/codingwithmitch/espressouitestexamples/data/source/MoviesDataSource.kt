package com.codingwithmitch.espressouitestexamples.data.source

import com.codingwithmitch.espressouitestexamples.data.Movie
import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting

@OpenForTesting
interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}