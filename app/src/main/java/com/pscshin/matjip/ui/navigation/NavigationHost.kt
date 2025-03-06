package com.pscshin.matjip.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pscshin.matjip.ui.screens.ProfileScreen
import com.pscshin.matjip.ui.screens.SearchScreen
import com.pscshin.matjip.ui.screens.UserListsScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "user_lists",
        modifier = Modifier.padding(padding),
        builder = {
            composable("user_lists") {
                UserListsScreen()
            }
            composable("search") {
                SearchScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    )
}