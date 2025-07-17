package com.example.quizapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizapp.R
import com.example.quizapp.ViewModel.QuizViewModel

@Composable
fun ResultScreen(score: Int, total: Int,
                 playerName:String,
                 onRestart: () -> Unit){
    val viewModel:QuizViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.ic_bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 10.dp)
            )
    }

    Column(modifier = Modifier
        .padding(vertical = 40.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Result", fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Image(painter = painterResource(id = R.drawable.ic_trophy),
            contentDescription = "Winner Cup",
            modifier = Modifier
                .height(300.dp)
                .padding(bottom = 30.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = "Congratulations!", fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(text = playerName, fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(text = "Your Score is $score out of $total",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 20.dp))
        Button(onClick =
            onRestart , modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "FINISH")
        }
        
    }
    
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ResultScreenPreview(){
    ResultScreen(0,0, "", {})
}