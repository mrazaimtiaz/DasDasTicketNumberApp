package com.gicproject.salamticketnumberapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gicproject.salamticketnumberapp.led.LampsUtil
import com.gicproject.salamticketnumberapp.presentation.MyViewModel
import com.gicproject.salamticketnumberapp.presentation.QuestionScreen
import com.gicproject.salamticketnumberapp.presentation.SettingScreen
import com.gicproject.salamticketnumberapp.ui.theme.TicketNumberAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var lamp = LampsUtil()


        setContent {

            val viewModel: MyViewModel = hiltViewModel()
            val darkTheme = viewModel.isDarkTheme.value
            val systemUiController = rememberSystemUiController()
           // systemUiController.isSystemBarsVisible = false

            TicketNumberAppTheme(darkTheme = darkTheme) {
                systemUiController.setSystemBarsColor(
                    color = MaterialTheme.colors.primary
                )
                Surface(color = MaterialTheme.colors.surface) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TicketScreen.route
                    ) {
                        composable(
                            route = Screen.TicketScreen.route
                        ) {
                          //  viewModel.ledGreenOff()
                        //    viewModel.ledRedOn()
                   //All the blue lights on


                            QuestionScreen(navController, viewModel = viewModel)
                        }
                        composable(Screen.SettingScreen.route) {
                            SettingScreen(navController,viewModel)
                        }
                    }
                }
            }
        }
    }

}



@Composable
fun Greeting(navController: NavController,viewModel: MyViewModel) {
    QuestionScreen(navController, viewModel = viewModel)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicketNumberAppTheme() {
        val viewModel: MyViewModel = hiltViewModel()
        val navController = rememberNavController()
        Greeting(navController, viewModel = viewModel)
    }
}

