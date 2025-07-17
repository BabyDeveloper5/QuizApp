package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.View.HomeScreen
import com.example.quizapp.View.QuizScreen
import com.example.quizapp.View.ResultScreen
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizApp()
                }
            }
        }
    }
}


@Composable
fun QuizApp() {
    val navController = rememberNavController()
    val viewModel: QuizViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen(viewModel = viewModel){name->
                viewModel.playerName = name
                navController.navigate("quiz")
            }
        }
        composable("quiz") {
            QuizScreen(viewModel = viewModel) {
                navController.navigate("result")
            }
        }
        composable("result") {
            ResultScreen(
                score = viewModel.score.value,
                total = viewModel.totalQuestions,
                playerName = viewModel.playerName
            ) {
                viewModel.resetQuiz()
                navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }
            }
        }
    }
}