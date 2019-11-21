package com.codingwithmitch.espressouitestexamples.ui.main

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondaryActivityTest::class
    )
class ActivityTestSuite