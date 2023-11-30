package com.lighthouse.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lighthouse.domain.repository.DrivenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DrivenRepository
) : ViewModel() {
    var homeState by mutableStateOf(HomeState())
        private set

    init {
        getDrivenData()
    }

    private fun getDrivenData() {
        viewModelScope.launch {
            repository.getDriven()
                .collect {
                    homeState = homeState.copy(
                        drivenData = it
                    )
                }
        }
    }
}