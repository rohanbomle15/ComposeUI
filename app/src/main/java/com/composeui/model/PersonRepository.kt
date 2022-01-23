package com.composeui.model

class PersonRepository {
    private val listOfPersons = listOf(
        person1, person2, person3, person4, person5, person6, person7,
        person8, person9, person10
    )

    fun getPersonsList(): List<Person> {
        return listOfPersons
    }

    fun getPersonById(id: String): Person? {
        return listOfPersons.find { it.id == id }
    }
}

val person1 = Person(
    "1",
    "Jhon",
    "Looking to meet some new people and see what happens. I am a guy interested in destroying your lipstick not your mascara",
    "https://unsplash.com/photos/NOWnVCTZIIM",
    Gender.Male,
    89.4f,
    "American",
    "Iverness, Florida",
    34,
    PersonLabel.Elder,
    Behaviour.Loyal,
    Vaccination.Vaccinated,
    "Healthy"
)

val person2 = Person(
    "2",
    "Nancy",
    "I am kind of hoping that your standards are lower than mine. I understand… I always do. Were you arrested earlier? It has got to be illegal to look that good.",
    "https://unsplash.com/photos/qrCmguAfqAg",
    Gender.Female,
    59.3f,
    "American",
    "JacksonVille, Florida",
    25,
    PersonLabel.Young,
    Behaviour.Happy,
    Vaccination.Unvaccinated,
    "Healthy"
)

val person3 = Person(
    "3",
    "Herman",
    "I love myself. Swipe right only is you love me as well. If you cannot laugh at yourself, then I will happily do it for you.",
    "https://unsplash.com/photos/2xEVQci6vK4",
    Gender.Male,
    52.2f,
    "Indian-American",
    "Colorado Springs, Colorado",
    29,
    PersonLabel.Elder,
    Behaviour.Stubborn,
    Vaccination.Vaccinated,
    "Healthy"
)

val person4 = Person(
    "4",
    "Daisy",
    "I am a challenger, i challenge you to swipe right. A thoughtful of mind with positive is my strong point.",
    "https://unsplash.com/photos/1H52tHTJPiI",
    Gender.Female,
    55.8f,
    "American",
    "Whitewright, Texas",
    22,
    PersonLabel.Young,
    Behaviour.Excited,
    Vaccination.Vaccinated,
    "Healthy"
)

val person5 = Person(
    "5",
    "Micy",
    "My ventriloquist dummy and I are a package deal. I am cinderella looking for her prince. Will send you pictures in exchange for pizza.",
    "https://unsplash.com/photos/Ncyum2ob9ow",
    Gender.Female,
    59.5f,
    "Mexican",
    "Starkville, Mississippi",
    32,
    PersonLabel.Elder,
    Behaviour.Angry,
    Vaccination.Vaccinated,
    "Disabled"
)
val person6 = Person(
    "6",
    "Sky",
    "I make a great plus one at family functions and weddings. A little adjustment is always better than a valueless argument. My character is the dignity for my love life.",
    "https://unsplash.com/photos/dItpRf02SG0",
    Gender.Female,
    42.3f,
    "American",
    "Fairfax, Virginia",
    21,
    PersonLabel.Young,
    Behaviour.Friendly,
    Vaccination.Unvaccinated,
    "Diarrhoea"
)

val person7 = Person(
    "7",
    "Yuki",
    "I am a star. To get me just look at the sky. I am looking for you. Faith in my eyes, so miracle may happen that is you. I am so busy, I couldn’t update my bio.",
    "https://unsplash.com/photos/u3WdX52t-UI",
    Gender.Male,
    62.4f,
    "American",
    "Quinlan, Texas",
    23,
    PersonLabel.Young,
    Behaviour.Friendly,
    Vaccination.Unvaccinated,
    "Heartworm"
)

val person8 = Person(
    "8",
    "Lilly",
    "I am busy with nothing. Be my everything.  When i find the keys of success always someone change my lock. I just want to you. That is all about. Be mine swiping right.",
    "https://unsplash.com/photos/3nNHM7VxiiY",
    Gender.Female,
    44.7f,
    "American",
    "Sharon, Connecticut",
    25,
    PersonLabel.Young,
    Behaviour.Stubborn,
    Vaccination.Unvaccinated,
    "Healthy"
)

val person9 = Person(
    "9",
    "Joy",
    "Stupid things i do. But i don’t want to lose you for my stupidity. Love is in air. So why you couldn’t feel it while breathing.",
    "https://unsplash.com/photos/aFYBJvqpn8s",
    Gender.Male,
    55.8f,
    "Spanish",
    "Norco, California",
    30,
    PersonLabel.Elder,
    Behaviour.Stubborn,
    Vaccination.Vaccinated,
    "Arthritis"
)

val person10 = Person(
    "10",
    "Kevin",
    "Every message comes to my mobile i think it’s yours. My mind is always empty. Because I think heartily. I don’t try to impress everyone because everyone doesn’t matter.\n",
    "https://unsplash.com/photos/nyL3A4FQS5c",
    Gender.Male,
    88.3f,
    "American",
    "Houston, Texas",
    24,
    PersonLabel.Young,
    Behaviour.Excited,
    Vaccination.Vaccinated,
    "Healthy"
)