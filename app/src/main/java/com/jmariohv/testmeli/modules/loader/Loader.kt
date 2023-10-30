package com.jmariohv.testmeli.modules.loader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jmariohv.testmeli.ui.theme.ColorSecundary

@Composable
fun Loader() {
    CircularProgressIndicator(
        modifier = Modifier.size(60.dp),
        color = ColorSecundary
    )
}

@Composable
fun LoaderScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Loader()
    }
}

@Preview
@Composable
fun LoaderPreview() {
    LoaderScreen()
}