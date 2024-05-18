package com.jetbrains.spacetutorial.cahe.cahe

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.jetbrains.spacetutorial.cache.AppDatabaseSpace
import com.jetbrains.spacetutorial.cache.DatabaseDriverFactory


class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabaseSpace.Schema, "launch.db")
    }
}

