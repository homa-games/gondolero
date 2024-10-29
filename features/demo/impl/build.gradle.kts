import com.example.myapplication.conventionplugins.base.extensions.myAndroidLibConfig

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ktlintGradle)
    id("androidLib.base.config")
}

myAndroidLibConfig {
    namespace = "com.example.myapplication.demo.impl"
}

dependencies {
    api(project(":features:demo:api"))
    testImplementation(libs.junit)
}
