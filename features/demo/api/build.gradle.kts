plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ktlintGradle)
}

android {
    namespace = "com.example.myapplication.demo.api"
    compileSdk = libs.versions.compileSdk.get().toInt()
}

dependencies {
}
