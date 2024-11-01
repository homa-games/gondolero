import com.example.myapplication.conventionplugins.base.extensions.myAndroidLibConfig

plugins {
    id("myAndroid.library.plugin")
    alias(libs.plugins.ktlintGradle)
}

myAndroidLibConfig {
    namespace = "com.example.myapplication.demo.impl"
}

dependencies {
    api(project(":features:demo:api"))
    testImplementation(libs.junit)
}
