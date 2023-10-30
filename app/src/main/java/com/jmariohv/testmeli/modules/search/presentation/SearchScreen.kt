package com.jmariohv.testmeli.modules.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jmariohv.testmeli.modules.dialog.ShowMessageDialog
import com.jmariohv.testmeli.modules.loader.Loader
import com.jmariohv.testmeli.modules.search.model.Results


@Preview
@Composable
fun PreviewItem() {
    ItemResults(
        results = Results().copy(
            title = "Apple iPhone 15 Pro (256 Gb) - Titanio Blanco , Liberado par cualquier compáñia",
            thumbnail = "http://http2.mlstatic.com/D_812116-MLA71783168214_092023-I.jpg",
            price = 98999.0,
        )
    ) {

    }
}


@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    onNextScreen: () -> Unit,
) {

    var search by remember { mutableStateOf("") }
    var showSearch by remember { mutableStateOf(false) }
    val results = viewModel.results.collectAsState(arrayListOf())
    val showLoader by viewModel.showLoader.observeAsState(initial = false)
    var showDialog by remember { mutableStateOf(true) }
    val showDialogError by viewModel.showDialogServiceError.observeAsState(initial = false)
    val showMsgError by viewModel.showMsgServiceError.observeAsState(initial = "Error")

    Column(modifier = Modifier.padding(bottom = 56.dp)) {
        CustomSearchView(search = search, onValueChange = {
            search = it
            if (search != "") {
                showSearch = true
                viewModel.search(search.trim())

            }
        })


        if (showSearch) {
            results.value.let { it ->
                if (it.size > 0) {
                    LazyColumn(Modifier) {
                        items(it) { result ->
                            ItemResults(result) { result ->
                                viewModel.selectedItem(result)
                                onNextScreen.invoke()
                            }
                        }
                    }
                }
            }
        }

    }

    if (showLoader) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            Loader()
        }
    }


    if (showDialogError) {
        ShowMessageDialog(
            showMessageDialog = showDialog,
            message = showMsgError,
            onDismiss = {
                viewModel.showDialogError(false)
            }
        )
    }

}

