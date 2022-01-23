package com.composeui.model

data class Person(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val gender: Gender,
    val weightKg: Float,
    val ethnicity: String,
    val location: String,
    val age: Int,
    val label: PersonLabel,
    val behavior: Behaviour,
    val vaccination: Vaccination,
    val health: String
)

enum class PersonLabel {
    Young,
    Elder
}

enum class Behaviour {
    Friendly,
    Stubborn,
    Angry,
    Happy,
    Excited,
    Lazy,
    Loyal
}

enum class Gender {
    Male,
    Female,
    NotSpecified
}

enum class Vaccination {
    Vaccinated,
    Unvaccinated
}
