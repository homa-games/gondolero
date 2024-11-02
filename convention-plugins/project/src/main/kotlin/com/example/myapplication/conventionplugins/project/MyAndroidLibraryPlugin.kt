package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.base.extensions.myAndroidLibConfig
import com.example.myapplication.conventionplugins.base.extensions.myKotlinOptions
import com.example.myapplication.conventionplugins.base.extensions.verLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

class MyAndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(verLibs.plugins.androidLibrary.get().pluginId)
                apply(verLibs.plugins.jetbrainsKotlinAndroid.get().pluginId)
            }
            myAndroidLibConfig {
                compileSdk = verLibs.versions.compileSdk.get().toInt()
                val javaVer = JavaVersion.toVersion(verLibs.versions.java.get().toInt())
                compileOptions {
                    sourceCompatibility = javaVer
                    targetCompatibility = javaVer
                }
                myKotlinOptions {
                    jvmTarget = JvmTarget.fromTarget(javaVer.toString())
                }
            }
        }
    }
}