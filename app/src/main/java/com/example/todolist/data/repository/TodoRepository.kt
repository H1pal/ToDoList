package com.example.todolist.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.todolist.data.model.TodoTask
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val gson = GsonBuilder()
        .registerTypeAdapter(
            LocalDate::class.java,
            JsonDeserializer { json, _, _ ->
                LocalDate.parse(json.asString)
            }
        )
        .registerTypeAdapter(
            LocalDate::class.java,
            JsonSerializer { src: LocalDate, _, _ ->
                JsonPrimitive(src.toString())
            }
        )
        .create()

    companion object {
        private val TODOLIST_KEY = stringSetPreferencesKey("todo_list")
    }

    val todoTasks : Flow<List<TodoTask>> = dataStore.data.map { preferences ->
        val serializedSet = preferences[TODOLIST_KEY] ?: emptySet()

        serializedSet
            .map { jsonString ->
                gson.fromJson(
                    jsonString,
                    TodoTask::class.java
                )
            }
            .filterNotNull()
            .sortedBy { it.id }
    }

    suspend fun setTasks(tasks: List<TodoTask?>) {
        val serializedSet = tasks.map { task ->
            gson.toJson(task)
        }.toSet()

        dataStore.edit { it[TODOLIST_KEY] = serializedSet }
    }

    suspend fun clearTask() {
        dataStore.edit { it[TODOLIST_KEY] = emptySet() }
    }
}