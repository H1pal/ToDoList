package com.example.todolist.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.todolist.data.model.TodoTask
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.collections.map
import kotlin.collections.sortedBy
import kotlin.jvm.java

class TodoRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val gson = Gson()
    companion object {
        private val TODOLIST_KEY = stringSetPreferencesKey("todo_list")
    }

    val todoTasks : Flow<List<TodoTask>> = dataStore.data.map { preferences ->
        val serializedSet = preferences[TODOLIST_KEY] ?: emptySet()

        serializedSet
            .map { jsonString ->
                gson.fromJson(jsonString, TodoTask::class.java)
            }.sortedBy { it.id }
    }

    suspend fun setTasks(tasks: List<TodoTask?>) {
        val serializedSet = tasks.map { task ->
            gson.toJson(task)
        }.toSet()

        dataStore.edit { it[TODOLIST_KEY] = serializedSet }
    }
}