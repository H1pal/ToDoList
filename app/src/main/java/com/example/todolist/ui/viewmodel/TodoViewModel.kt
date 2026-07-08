package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.data.model.TodoTask
import com.example.todolist.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {
    val todoList: StateFlow<List<TodoTask>> = todoRepository.todoTasks
        .stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )

    private var currentTodoTask: TodoTask? = null

    fun setTodoInfo(title: String, description: String) {
        currentTodoTask = TodoTask(title = title, description = description)
    }

    fun setTodoTime(time: String) {
        currentTodoTask = currentTodoTask?.copy(time = time)
    }

    fun setSchedule(date: LocalDate) {
        currentTodoTask = currentTodoTask?.copy(date = date) ?: return

        viewModelScope.launch {
            val outcomeList = todoList.value + currentTodoTask
            todoRepository.setTasks(outcomeList)
            currentTodoTask = null
            println("저장")
        }
    }

    fun clearTask() {
        viewModelScope.launch {
            todoRepository.clearTask()
            currentTodoTask = null
            println("삭제")
        }
    }
}