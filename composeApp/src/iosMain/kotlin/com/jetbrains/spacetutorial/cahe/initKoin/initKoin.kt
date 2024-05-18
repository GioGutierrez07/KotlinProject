package com.jetbrains.spacetutorial.cahe.initKoin

import com.jetbrains.spacetutorial.SpaceXSDK

import com.jetbrains.spacetutorial.cahe.cahe.IOSDatabaseDriverFactory
import com.jetbrains.spacetutorial.network.SpaceXApi
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(module {
            single<SpaceXApi> { SpaceXApi() }
            single<SpaceXSDK> {
                SpaceXSDK(
                    databaseDriverFactory = IOSDatabaseDriverFactory(), api = get()
                )
            }
        })
    }
}