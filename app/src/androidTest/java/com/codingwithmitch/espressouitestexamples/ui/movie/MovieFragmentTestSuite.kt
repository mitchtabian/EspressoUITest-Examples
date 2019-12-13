package com.codingwithmitch.espressouitestexamples.ui.movie

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    MovieListFragmentTest::class,
    MovieDetailFragmentTest::class
)
class MovieFragmentTestSuite