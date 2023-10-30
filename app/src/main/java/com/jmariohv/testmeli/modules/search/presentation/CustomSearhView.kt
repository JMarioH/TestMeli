package com.jmariohv.testmeli.modules.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.jmariohv.testmeli.R
import com.jmariohv.testmeli.ui.theme.ColorGray


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchView(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {

    Box(
        modifier = modifier.fillMaxWidth()
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.White)

    ) {
        TextField(
            value = search,
            onValueChange = onValueChange,
            Modifier.fillMaxWidth().height(46.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Color.White,
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    color = Color.White,
                    style = TextStyle(fontStyle = FontStyle.Normal)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = ColorGray,
                placeholderColor = Color.White,
                textColor = Color.White,
                focusedIndicatorColor = Color.Transparent, cursorColor = Color.White
            )
        )
    }

}