package com.azabost.quest.build

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object Config {
    val javaVersion = JavaVersion.VERSION_17
    val kotlinJvmTarget = JvmTarget.fromTarget(javaVersion.toString())
    val minSdk = 28
    val compileSdk = 36
    val targetSdk = 36
}