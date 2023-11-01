package com.utsman.generator

import kotlin.math.abs
import kotlin.random.Random

object NameGenerator {
    private val names = """
            Ella Mueller
            Lawrence Carter
            Husna Mooney
            Kieran Hatfield
            Traci Munoz
            Joshua Osborne
            Judith Arias
            Samuel Pitts
            Johnathan Mcintyre
            Caiden Sutton
            Maximus Norris
            Justin Lloyd
            Stacey Mercado
            Darragh Montoya
            Omari Reese
            Emilie Rasmussen
            Tomas Farley
            Keeley Mitchell
            Ismael Winter
            Olive Poole
            Melody Bentley
            Simon Horne
            Alessia Dale
            Safia Villa
            Samantha Houston
            Leonardo Barrett
            Adriana Chen
            Kezia Andrews
            Alyssia Yang
            Marnie Carson
            Roisin Lamb
            Syed Jacobs
            Pamela O'Neill
            Hassan Mcpherson
            Euan Gentry
            Katy Moran
            Lee Monroe
            Tobias Lowe
            Yasmin Wiley
            Saarah Watts
            Erica Hendrix
            Rafferty Flores
            Ffion Vargas
            Maximilian Bond
            Rosemary Mills
            Mackenzie Guerra
            Magnus Villegas
            Annika Hanna
            Donald Dunn
            Hector Abbott
            Ameer Richards
            Yuvraj Mcdowell
            Andre Velasquez
            Zak Petty
            Anisha Leonard
            Hiba Zimmerman
            Wesley Mcmahon
            Isabella Leblanc
            Mariah Byrne
            Eshal Campos
            Kobe Banks
            Hattie Kemp
            Arnold Buck
            Shirley Santiago
            Cecily Wilson
            Agnes Kaufman
            Leighton Jennings
            Grace Tyler
            Rhea Mckinney
            Eugene Greer
            Shelby Nelson
            Vivian Keller
            Evan Richard
            Qasim Wheeler
            Isaac Gordon
            Arjun Weeks
            Alvin Ramos
            Maria Kent
            Nathaniel Cantu
            Asia Pace
            Fern Woodward
            Ahmed Reed
            Ashleigh Mcgee
            Barbara Reyes
            Zahra Rose
            Alan Horton
            Lilia Morse
            Zara Mcintosh
            Travis O'Reilly
            Amaan Bernard
            Lori Singh
            Alexis Manning
            Layton Palmer
            Colby Cisneros
            Tyrell May
            Candice Mcconnell
            Phoebe Hampton
            Marc Ortiz
            Karim Lester
            Chelsey Rosario
            Safiyyah Carlson
            Vivian Suarez
            Abdirahman Larsen
            Halima Greene
            Harriett Newman
            Faris Cooper
            Selina Gillespie
            Alisa Ortiz
            Franklin Ramsey
            Stephanie Tate
            Dawson Erickson
            Ayah Wade
            Elliot Archer
            Izaak Stephenson
            Arianna Key
            Gabrielle Martinez
            Christina Walters
            Isobelle Mcclure
            Mabel Craig
            Jackson Carey
            Keisha Long
            Michael Jefferson
            Denzel Dunlap
            Ria Escobar
            Willard Webb
            Wade Leon
            Carolyn Mason
            Milton Tyler
            Harvey Beard
            Zaynah Marsh
            Helen Casey
            Saba Davies
            Abdullahi Oconnor
            David Wheeler
            Wesley Ponce
            Elaine Keller
            Kamil Davila
            Caroline Eaton
            Fay Dale
            Rahim Kramer
            Bryn Fox
            Stacey Stokes
            Ellen Stevenson
            Julie Sullivan
            Trey Brennan
            Reggie O'Reilly
            Kayla Black
            Caspar Dejesus
            Martin Shepard
            Serena Lopez
            Saul Kirby
            Miah Willis
            Holly Dotson
            Malachy Morris
            Danielle Mercado
            Janice Hull
            Asiya Patrick
            Tianna Vincent
            Georgiana Collier
            Abdul Baxter
            Virgil Mcmillan
            Saif Patel
            Otto Donaldson
            Eliza Sweeney
            Callie Hopkins
            Scarlett Holloway
            Cole Holman
            Harmony Bush
            Haaris Crawford
            Connie Hendricks
            Pablo Dominguez
            Viola Thomson
            Alannah Hurst
            Flora Mcpherson
            Anne Bell
            Aryan Sanders
            Josephine Mclean
            Anya Cortez
            Matilda Terrell
            Luther Salas
            Malik Lucas
            Archibald Baker
            Kallam George
            Tasnim Edwards
            Kira Petty
            Lois Chase
            Jimmy Rogers
            Amber Vasquez
            Clayton Barnett
            Justin Skinner
            Fahad Rose
            Violet Wagner
            April Hicks
            Poppie Harris
            Imran Patton
            Krishan Woods
            Salman Li
            Fleur Boyd
            Raymond Hampton
            Denise Yoder
        """.trimIndent()
        .split(Regex("\\s+"))

    fun generateNameFromString(string: String, size: Int): List<String> {
        val hash = string.hashCode().toLong()
        val uniqueLong = abs(hash % 10000)
        val random = Random(uniqueLong)
        val randomShuffle = names
            .shuffled(random)

        val nameRandom = randomShuffle.take(size)
        val combinedList = mutableListOf<String>()
        var currentPair = ""

        for (name in nameRandom) {
            if (currentPair.isEmpty()) {
                currentPair = name
            } else {
                currentPair += " $name"
                combinedList.add(currentPair)
                currentPair = ""
            }
        }

        if (currentPair.isNotEmpty()) {
            combinedList.add(currentPair)
        }

        return combinedList
    }
}