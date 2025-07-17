package com.example.quizapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ViewModel.QuizViewModel

@Composable
fun HomeScreen(viewModel: QuizViewModel, onStartClicked: ( String ) -> Unit){



    var name by remember{ mutableStateOf("") }



    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.ic_bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 10.dp)
        )
    }


    Column (modifier = Modifier
        .padding(vertical = 16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Quiz App!", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Card (modifier = Modifier
            .padding(16.dp)
            .height(300.dp),
            shape = RoundedCornerShape(20.dp)
        ){
            Column(modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 45.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Welcome",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Please enter your name", fontSize = 20.sp)
                OutlinedTextField(value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Name")
                    },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { onStartClicked(name) },
                    enabled = name.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Start")
                }
            }
        }
    }


}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomePreview(){
    HomeScreen(viewModel = QuizViewModel(), {})
}