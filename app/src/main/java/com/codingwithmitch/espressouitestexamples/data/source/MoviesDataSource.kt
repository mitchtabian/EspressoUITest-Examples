package com.codingwithmitch.espressouitestexamples.data.source

import com.codingwithmitch.espressouitestexamples.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}