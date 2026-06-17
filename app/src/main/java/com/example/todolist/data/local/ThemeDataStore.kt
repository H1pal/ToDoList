package com.example.todolist.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences

val Context.themeDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val THEME_KEY = stringPreferencesKey("selected_theme")