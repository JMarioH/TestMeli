package com.jmariohv.testmeli.modules.search_detail.presentation

import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.jmariohv.testmeli.R
import com.jmariohv.testmeli.modules.dialog.ShowMessageDialog
import com.jmariohv.testmeli.modules.loader.Loader
import com.jmariohv.testmeli.modules.search.presentation.SearchViewModel
import com.jmariohv.testmeli.network.NetworkStatus

@Composable
fun SearchDetailScreen(
    viewModel: SearchViewModel,
    connectiveStatus: NetworkStatus.Status,
    onBackScreen: () -> Unit
) {

    var isLoading by remember { mutableStateOf(true) }
    var showDialogError by remember { mutableStateOf(false) }
    showDialogError = connectiveStatus == NetworkStatus.Status.Desconectado

    val item = viewModel.itemResult.value
    item?.let {
        var loadFinished by remember { mutableStateOf(false) }
        AndroidView(factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        isLoading = true
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        isLoading = false
                        loadFinished = true
                    }
                }
                loadUrl(item.permalink.toString())
            }
        }, update = {
            if (!loadFinished) {
                it.loadUrl(item.permalink.toString())
            }
        })

        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Loader()
            }
        }
    }
    if (showDialogError) {
        ShowMessageDialog(
            showMessageDialog = showDialogError,
            message = LocalContext.current.getString(R.string.network_error),
            onDismiss = {
               showDialogError = false
            }
        )
    }



}