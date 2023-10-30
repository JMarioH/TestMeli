package com.jmariohv.testmeli.modules.search.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.jmariohv.testmeli.modules.search.model.Results
import com.jmariohv.testmeli.ui.theme.ColorGray
import com.jmariohv.testmeli.ui.theme.ColorText

@Composable
fun ItemResults(results: Results, onItemSelect: (Results) -> Unit) {

    results.let {

        val price = String.format("%.2f", it.price?.div(1.0) ?: 0.0)
        Row(
            modifier = Modifier.fillMaxWidth().height(90.dp).padding(start = 16.dp, end = 16.dp)
                .clickable {
                    onItemSelect.invoke(results)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            results.thumbnail.let {
                val painter = rememberAsyncImagePainter(it)
                val state = painter.state

                val transition by animateFloatAsState(
                    targetValue = if (state is AsyncImagePainter.State.Success) 1f else 0f,
                    label = ""
                )
                Image(
                    painter = painter,
                    contentDescription = "description",
                    modifier = Modifier
                        .alpha(transition).size(60.dp)
                )
            }

            Column {
                Text(
                    text = it.title.toString(),
                    modifier = Modifier.padding(start = 8.dp),
                    color = ColorGray,
                    textAlign = TextAlign.Justify
                )

                Text(
                    text = "$ $price",
                    modifier = Modifier.padding(start = 8.dp),
                    color = ColorText,
                    textAlign = TextAlign.Justify,
                    fontSize = 18.sp
                )


            }
        }
    }

}
