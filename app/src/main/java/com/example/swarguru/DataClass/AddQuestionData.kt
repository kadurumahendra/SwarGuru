package com.example.swarguru.DataClass

data class AddQuestionData(
    val level: String,
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val correctAnswer: String
)
