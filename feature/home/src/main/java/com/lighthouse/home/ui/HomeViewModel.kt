package com.lighthouse.home.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lighthouse.domain.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    private var page by mutableStateOf(1)
    private var canPaginate by mutableStateOf(false)
    var homeState by mutableStateOf(HomeState())
        private set

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnPagingStart -> {
                getQuestion()
            }
        }
    }

    private fun getQuestion() {
        if (page == 1 || (page != 1 && canPaginate) && !homeState.isLoading) {
            homeState = homeState.copy(isLoading = true)
            viewModelScope.launch(Dispatchers.IO) {
                repository.getQuestion(
                    pageSize = homeState.pageSize,
                    page = page,
                )
                    .catch {
                        homeState = homeState.copy(
                            isLoading = false,
                            isError = it.message
                        )
                        Log.e("HomeViewModel", "getQuestion: ${it.message}")
                    }
                    .collect {
                        Log.d("HomeViewModel", "getQuestion: $it")
                        canPaginate = it.questions.size == homeState.pageSize
                        homeState = if (page == 1) {
                            homeState.copy(
                                isLoading = false,
                                questions = it.questions,
                                isError = null
                            )
                        } else {
                            homeState.copy(
                                isLoading = false,
                                questions = homeState.questions + it.questions,
                                isError = null
                            )
                        }
                        if (canPaginate) {
                            page++
                        }
                    }
            }
        }
    }
}