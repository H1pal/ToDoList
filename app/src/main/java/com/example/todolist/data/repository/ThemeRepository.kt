package com.example.todolist.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemeRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val THEME_KEY = stringPreferencesKey("select_theme")
    }

    val theme: Flow<String> = dataStore.data.map { it[THEME_KEY] ?: "Aqua" }

    suspend fun setTheme(theme: String) {
        dataStore.edit { it[THEME_KEY] = theme }
    }
}