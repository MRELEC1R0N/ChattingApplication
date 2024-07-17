package com.example.chattingapplication.BottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuScreen(
    val route: String,
    val title: String,
    val icon: ImageVector

){
    object ProfilePage : BottomMenuScreen(
        route = "ProfilePage",
        title = "ProfilePage",
        icon = Icons.Outlined.Person
    )

    object Map: BottomMenuScreen(
        route = "MapScreen",
        title = "MapScreen",
        icon = Icons.Outlined.Map
    )

    object ChatScreen: BottomMenuScreen(
        route = "ChatScreen",
        title = "ChatScreen",
        icon = Icons.Outlined.Chat
    )
}