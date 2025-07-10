import com.azabost.quest.build.Config

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.testFixtures)
}

kotlin {
    jvmToolchain(Config.javaVersion.majorVersion.toInt())
    compilerOptions {
        jvmTarget = Config.kotlinJvmTarget
    }
}

java {
    sourceCompatibility = Config.javaVersion
    targetCompatibility = Config.javaVersion
}

dependencies{
    testFixturesImplementation(libs.kotlinx.coroutines.core)
}