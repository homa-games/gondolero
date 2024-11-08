// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.ktlintGradle) apply false
    id("project.plugin") //fixme из-за этой строчки падает сборка через build - rebuild. собирать через 'gradlew :app:assembleDebug' или build - make project
}
