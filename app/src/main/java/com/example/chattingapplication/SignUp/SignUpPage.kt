package com.example.chattingapplication.SignUp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SingUpPage( navController: NavHostController,modifier: Modifier = Modifier) {
    Text(text = "Idar Kuch Nahi Hai")
}


@Composable
fun SingUpPreview(){
    SingUpPage(rememberNavController())
}