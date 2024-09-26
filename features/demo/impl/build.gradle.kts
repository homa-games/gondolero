plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ktlintGradle)
}

android {
    namespace = "com.example.myapplication.demo.impl"
    compileSdk = libs.versions.compileSdk.get().toInt()
}

dependencies {
    implementation(project(":features:demo:api"))
    testImplementation(libs.junit)
}
