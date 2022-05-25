package fr.isen.rouveure.brainpwr.quizz

data class Question (
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    // Add true answer
        )