package com.example.todolist.data.model

import java.time.LocalDate

data class TodoTask(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val description: String,
    val date: LocalDate? = null,
    val time: String? = null
)