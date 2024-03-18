package br.com.fiap.appbreathe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.appbreathe.model.LocationViewModel
import br.com.fiap.appbreathe.pages.Cover
import br.com.fiap.appbreathe.pages.Home
import br.com.fiap.appbreathe.ui.theme.AppBreatheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppBreatheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    val navController = rememberNavController()
                    val locationViewModel = viewModel<LocationViewModel>()

                    NavHost(
                        navController = navController,
                        startDestination = "cover",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            //fadeIn(animationSpec = tween(2000))
                            slideIntoContainer(
                                towards =
                                AnimatedContentTransitionScope.SlideDirection.Start,
                                animationSpec = tween(1500)

                            )
                        }
                    ) {
                        composable(route = "cover") {
                            Cover(navController, context, locationViewModel)
                        }
                        composable(route = "home"){
                            Home(locationList = locationViewModel.locationList)
                        }

                    }
                }
            }


        }
    }
}



