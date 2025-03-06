package com.pscshin.matjip.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search

object NavigationConstants {
    val NavigationItems = listOf(
        NavigationItem(
            label = "Your Lists",
            icon = Icons.AutoMirrored.Filled.List,
            route = "user_lists"
        ),
        NavigationItem(
            label = "Search",
            icon = Icons.Filled.Search,
            route = "search"
        ),
        NavigationItem(
            label = "Profile",
            icon = Icons.Filled.Person,
            route = "profile"
        )
    )
}