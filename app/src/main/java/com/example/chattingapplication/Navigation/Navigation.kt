package com.example.chattingapplication.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.chattingapplication.LoginPage.LoginPage
import com.example.chattingapplication.SignUp.SingUpPage
import com.example.chattingapplication.BottomNavigation.BottomMenuScreen
import com.example.chattingapplication.ChatScreen.ChatScreen
import com.example.chattingapplication.MapScreen.MapScreen
import com.example.chattingapplication.Profile.ProfilePage


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        // Authentication Flow
        composable("login") { LoginPage(navController = navController) }
        composable("signup") { SingUpPage(navController = navController) }

        // Main App Flow (Using Bottom Navigation)
        composable("main") {
            MainScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    val bottomBarItems = listOf(
        BottomMenuScreen.ProfilePage,
        BottomMenuScreen.Map,
        BottomMenuScreen.ChatScreen
    )

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomBarItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the bottom navigation graph
                                popUpTo("main")
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->// Nested NavHost for the bottom navigation screens
        NavigationGraph(navController = navController, innerPadding = innerPadding)
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomMenuScreen.ProfilePage.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(BottomMenuScreen.ProfilePage.route) { ProfilePage(navController) }
        composable(BottomMenuScreen.Map.route) { MapScreen(navController) }
        composable(BottomMenuScreen.ChatScreen.route) { ChatScreen(navController) }
    }
}


