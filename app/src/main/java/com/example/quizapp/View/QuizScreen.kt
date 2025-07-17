package com.example.quizapp.View

import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ViewModel.QuizViewModel

@Composable
fun QuizScreen(viewModel:QuizViewModel, onQuizFinished: () -> Unit){

    val question = viewModel.currentQuestion
    val currentIndex by viewModel.currentQuestionIndex
    val totalQuestions = viewModel.totalQuestions
    val isFinished by viewModel.isQuizFinished
    var isCorrect by remember { mutableStateOf(false) }
    var isClicked by remember { mutableStateOf(false) }


    if (isFinished){
        // Navigate to ResultScreen
        onQuizFinished()
    }else{
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Progress bar
            LinearProgressIndicator(
                progress = (currentIndex + 1) / totalQuestions.toFloat(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Question number
            Text(text = "Question ${currentIndex + 1} of $totalQuestions",
                style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(8.dp))

            // Question text
            Text(text = question.text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Options
            question.options.forEachIndexed { index, option ->
                Button(onClick ={
                    viewModel.onAnswerSelected(index)
                    isClicked = true
                    if (index == question.correctAnswerIndex){
                        isCorrect = true
                    }
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),

                ) {
                    Text(text = option)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun QuizScreenPreview(){
    QuizScreen(viewModel = QuizViewModel()) {}
}