package com.jetbrains.spacetutorial.cahe

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.jetbrains.spacetutorial.cache.AppDatabaseSpace
import com.jetbrains.spacetutorial.cache.DatabaseDriverFactory


class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabaseSpace.Schema, context, "launch.db")
        }
}