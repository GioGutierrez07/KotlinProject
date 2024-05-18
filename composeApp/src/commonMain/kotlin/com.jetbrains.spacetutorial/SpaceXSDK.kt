package com.jetbrains.spacetutorial

import com.jetbrains.spacetutorial.cache.DataBase
import com.jetbrains.spacetutorial.cache.DatabaseDriverFactory
import com.jetbrains.spacetutorial.network.SpaceXApi


class SpaceXSDK (databaseDriverFactory: DatabaseDriverFactory, val api: SpaceXApi) {
    private val database = DataBase(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearAndCreateLaunches(it)
            }
            }
        }
}