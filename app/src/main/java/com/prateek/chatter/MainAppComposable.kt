package com.prateek.chatter

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.prateek.chatter.feature.auth.signin.SignInScreen
import com.prateek.chatter.feature.auth.signup.SignUpScreen
import com.prateek.chatter.feature.home.HomeScreen

@Composable

fun MainApp(){
    Surface(modifier=Modifier.fillMaxSize())
    {
        val navController = rememberNavController()
        val currentuser=FirebaseAuth.getInstance().currentUser
        val start = if(currentuser!=null) "home" else "login"
        NavHost(navController = navController, startDestination = "start") {

            composable("login")
            {
                SignInScreen(navController)
            }
            composable("signup")
            {
                SignUpScreen(navController)
            }
            composable("home")
            {
                HomeScreen(navController)
            }
            


        }
    }

}
