package com.codingwithmitch.espressouitestexamples.data


object FakeMovieData {

    val movies = arrayOf(
        Movie(
            0,
            "Avengers: Infinity War",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/Infinity_War-infinity_war.png",
            "The Avengers and their allies must be willing to sacrifice all in an attempt to " +
                    "defeat the powerful Thanos before his blitz of devastation and ruin puts an end to " +
                    "the universe.",
            arrayListOf("Anthony Russo", "Joe Russo"),
            arrayListOf("Robert Downey Jr.", "Chris Hemsworth", "Mark Ruffalo", "+ more...")
        ),
        Movie(
            1,
            "The Rundown",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
            "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                    "becomes involved in the fight against an oppressive town operator and the search " +
                    "for a legendary treasure.",
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        ),
        Movie(
            2,
            "The Godfather",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Godfather-fragment_factory.png",
            "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
            arrayListOf("Francis Ford Coppola"),
            arrayListOf("Marlon Brando", "Al Pacino", "James Caan")
        ),
        Movie(
            3,
            "The Dark Knight",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Dark_Knight-fragment_factory_1.png",
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            arrayListOf("Christopher Nolan"),
            arrayListOf("Christian Bale", "Heath Ledger", "Aaron Eckhart")
        ),
        Movie(
            4,
            "The Lord of the Rings: The Return of the King",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Lord_of_the_Rings_The_Return_of_the_King-fragment_factory_2.png",
            "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
            arrayListOf("Peter Jackson"),
            arrayListOf("Elijah Wood", "Viggo Mortensen", "Ian McKellen")
        )
    )
}