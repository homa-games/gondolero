plugins {
    id("myAndroid.library.plugin")
}

android {
    namespace = "com.example.myapplication.demo.impl"
}

dependencies {
    api(project(":features:demo:api"))
    testImplementation(libs.junit)
}
