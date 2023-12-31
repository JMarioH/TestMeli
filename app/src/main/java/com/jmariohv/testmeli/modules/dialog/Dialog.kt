package com.jmariohv.testmeli.modules.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.jmariohv.testmeli.ui.theme.ColorGray
import com.jmariohv.testmeli.ui.theme.ColorSecundary

@Composable
fun MessageDialog(
    message: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Column(
            modifier = Modifier.width(300.dp).height(250.dp).padding(16.dp)
                .background(color= Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = message,
                fontSize = 18.sp,
                modifier = Modifier.width(150.dp).padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Button(
                onClick = { onDismiss() },
                modifier = Modifier.width(150.dp)
            ) {
                Text("Aceptar")
            }
        }
    }
}

@Composable
fun ShowMessageDialog(
    showMessageDialog: Boolean,
    message: String,
    onDismiss: () -> Unit
) {
    if (showMessageDialog) {
        MessageDialog(
            message = message,
            onDismiss = onDismiss
        )
    }
}

@Preview
@Composable
fun MessageDialogPreview() {
    ShowMessageDialog(
        showMessageDialog = true,
        message = "test msg",
        onDismiss = {}
    )
}