import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.example.myapplcation.conventionplugins"

dependencies {
    implementation(libs.gradleplugin.android)
    implementation(libs.gradleplugin.kotlin)
    // Workaround for version catalog working inside precompiled scripts
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.gradlePlugin.ktlint)
}
private val projectJavaVersion: JavaVersion = JavaVersion.toVersion(libs.versions.java.get())

java {
    sourceCompatibility = projectJavaVersion
    targetCompatibility = projectJavaVersion
}
tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.fromTarget(projectJavaVersion.toString()))
}

gradlePlugin {
    plugins {
        register("myAndroid.application.plugin") {
            id = "myAndroid.application.plugin"
            implementationClass = "com.example.myapplication.conventionplugins.project.MyAndroidApplicationPlugin"
        }
        register("myAndroid.library.plugin") {
            id = "myAndroid.library.plugin"
            implementationClass = "com.example.myapplication.conventionplugins.project.MyAndroidLibraryPlugin"
        }
        register("myOptions.compiler.plugin") {
            id = "myOptions.compiler.plugin"
            implementationClass = "com.example.myapplication.conventionplugins.project.MyCompileOptionsPlugin"
        }
        register("myKtlint.linter.plugin") {
            id = "myKtlint.linter.plugin"
            implementationClass = "com.example.myapplication.conventionplugins.project.MyKtlintPlugin"
        }
    }
}
