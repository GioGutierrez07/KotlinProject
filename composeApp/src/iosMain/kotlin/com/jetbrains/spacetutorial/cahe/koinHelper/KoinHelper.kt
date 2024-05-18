package com.jetbrains.spacetutorial.cahe.koinHelper

import com.jetbrains.spacetutorial.RocketLaunch
import com.jetbrains.spacetutorial.SpaceXSDK
import org.koin.core.component.KoinComponent

import org.koin.core.component.inject

class KoinHelper  : KoinComponent {
    private val sdk: SpaceXSDK by inject<SpaceXSDK>()

    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        return sdk.getLaunches(forceReload = forceReload)
    }
}