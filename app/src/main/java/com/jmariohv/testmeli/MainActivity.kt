package com.jmariohv.testmeli

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jmariohv.testmeli.modules.base.BaseActivity
import com.jmariohv.testmeli.modules.navigation.SearchNavScreen
import com.jmariohv.testmeli.network.NetworkStatus
import com.jmariohv.testmeli.ui.theme.ColorYellowBase
import com.jmariohv.testmeli.ui.theme.TestMeliTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()
            TestMeliTheme {
                val status by connectivityObserver.observe().collectAsState(
                    initial = NetworkStatus.Status.Desconectado
                )
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(ColorYellowBase)
                }
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = Color.White

                ) {
                    SearchNavScreen(navController, status, onBackPress = ::onNavigationUp)

                }

            }
        }
    }

    private fun onNavigationUp() = finish()

}
