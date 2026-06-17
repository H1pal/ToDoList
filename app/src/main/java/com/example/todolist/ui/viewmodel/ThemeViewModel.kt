package com.example.todolist.ui.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.repository.ThemeRepository
import com.example.todolist.ui.theme.FourthColor
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.SecondColor
import com.example.todolist.ui.theme.ThirdColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeRepository: ThemeRepository
) : ViewModel() {

    val theme: StateFlow<Color> = themeRepository.theme
        .map { themeColor ->
            when (themeColor) {
                "Aqua" -> MainColor
                "Black" -> SecondColor
                "Red" -> ThirdColor
                "Blue" -> FourthColor
                else -> MainColor
            }
        }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = MainColor
    )

    fun setTheme(theme: String) {
        viewModelScope.launch {
            themeRepository.setTheme(theme)
        }
    }
}