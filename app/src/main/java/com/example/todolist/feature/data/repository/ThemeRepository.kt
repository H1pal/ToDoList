package com.example.todolist.feature.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import com.example.todolist.feature.data.local.THEME_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import javax.inject.Inject

class ThemeRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    val theme: Flow<String> = dataStore.data.map { it[THEME_KEY] ?: "Aqua" }

    suspend fun setTheme(theme: String) {
        dataStore.edit { it[THEME_KEY] = theme }
    }
}