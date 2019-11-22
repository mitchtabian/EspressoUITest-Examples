package com.codingwithmitch.espressouitestexamples.data

data class Movie (
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val directors: ArrayList<String>?,
    val star_actors: ArrayList<String>?
)