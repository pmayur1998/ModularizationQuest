import com.azabost.quest.build.Config

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ksp)
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

dependencies {
    // Retrofit
    implementation(libs.retrofit)

    // Hilt
    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
}