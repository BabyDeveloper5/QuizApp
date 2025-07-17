package com.example.quizapp.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quizapp.Model.Question
import com.example.quizapp.Model.sampleQuestions

class QuizViewModel : ViewModel() {


    private val questions = sampleQuestions

    private var _currentQuestionIndex = mutableStateOf(0)
    val currentQuestionIndex: State<Int> = _currentQuestionIndex

    val currentQuestion: Question
        get() = questions[_currentQuestionIndex.value]

    private var _score = mutableStateOf(0)
    val score: State<Int> = _score

    val totalQuestions: Int
        get() = questions.size

    private var _isQuizFinished = mutableStateOf(false)
    val isQuizFinished: State<Boolean> = _isQuizFinished

     var playerName by mutableStateOf("")


    fun onAnswerSelected(selectedIndex: Int) {
        val correctIndex = currentQuestion.correctAnswerIndex
        if (selectedIndex == correctIndex) {
            _score.value += 1
        }

        if (_currentQuestionIndex.value < questions.size - 1) {
            _currentQuestionIndex.value += 1
        } else {
            _isQuizFinished.value = true
        }
    }

    fun resetQuiz() {
        _currentQuestionIndex.value = 0
        _score.value = 0
        _isQuizFinished.value = false
    }

}