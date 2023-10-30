package com.jmariohv.testmeli.modules.search.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmariohv.testmeli.R
import com.jmariohv.testmeli.modules.search.domain.SearchRepository
import com.jmariohv.testmeli.modules.search.model.Results
import com.jmariohv.testmeli.network.ApiServiceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val context: Application
) :
    ViewModel() {

    private var _results = MutableStateFlow(arrayListOf(Results()))
    val results: MutableStateFlow<ArrayList<Results>> = _results

    private val _itemResult = MutableLiveData<Results>()
    val itemResult: MutableLiveData<Results> = _itemResult

    private val _showLoader = MutableLiveData(false)
    var showLoader: MutableLiveData<Boolean> = _showLoader

    private val _showDialogErrornetwork = MutableLiveData(false)
    var showDialogErrorNetwork: MutableLiveData<Boolean> = _showDialogErrornetwork

    private val _showDialogServiceError = MutableLiveData(false)
    var showDialogServiceError: MutableLiveData<Boolean> = _showDialogServiceError

    private val _showMsgServiceError = MutableLiveData("")
    var showMsgServiceError: MutableLiveData<String> = _showMsgServiceError

    fun selectedItem(item: Results) {
        _itemResult.value = item
    }

    fun showDialogError(show: Boolean) {
        _showDialogServiceError.value = show
    }

    fun search(search: String) {
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            searchRepository.search(value = search).onEach { response ->
                when (response) {
                    is ApiServiceState.Loading -> {
                        _showLoader.value = true
                    }

                    is ApiServiceState.Success -> {
                        showLoader.value = false
                        response.data.let { results ->
                            results?.let {
                                if (results.results.isNotEmpty()) {
                                    _results.value = results.results
                                } else {
                                    _showDialogServiceError.value = true
                                    _showMsgServiceError.value =
                                        context.getString(R.string.error_service_result)
                                }

                            }
                        }
                    }

                    is ApiServiceState.Error -> {
                        showLoader.value = false
                        showDialogServiceError.value = true
                        _showMsgServiceError.value = response.exception.error?.message
                    }
                }

            }.launchIn(viewModelScope)
        }

    }
}