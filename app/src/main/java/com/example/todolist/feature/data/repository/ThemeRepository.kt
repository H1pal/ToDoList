package com.example.todolist.feature.data.local.taskTodo

import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences
import javax.inject.Inject
import kotlin.text.get

class ThemeRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    val theme: Flow<String> = dataStore.data.map { it[THEME_KEY] ?: "Aqua" }

    suspend fun setTheme(theme: String) {
        dataStore.edit { it[THEME_KEY] = theme }
    }
}