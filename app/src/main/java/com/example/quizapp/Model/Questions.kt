package com.example.quizapp.Model

data class Question (
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)