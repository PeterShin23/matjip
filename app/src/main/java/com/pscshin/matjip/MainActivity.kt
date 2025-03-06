package com.pscshin.matjip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.pscshin.matjip.ui.navigation.BottomNavigationBar
import com.pscshin.matjip.ui.navigation.NavigationHost
import com.pscshin.matjip.ui.theme.MatjipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatjipTheme {
                val navController = rememberNavController()
                Surface(color = Color.White) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        },
                        content = { padding ->
                            NavigationHost(
                                navController = navController,
                                padding = padding
                            )
                        }
                    )
                }
            }
        }
    }
}
