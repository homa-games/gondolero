package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.base.extensions.myAndroidAppConfig
import com.example.myapplication.conventionplugins.base.extensions.verLibs
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyAndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(verLibs.plugins.androidApplication.get().pluginId)
                apply(verLibs.plugins.jetbrainsKotlinAndroid.get().pluginId)
                apply("myOptions.compiler.plugin")
                apply("myKtlint.linter.plugin")
            }
            myAndroidAppConfig {
                compileSdk = verLibs.versions.compileSdk.get().toInt()
                defaultConfig {
                    minSdk = verLibs.versions.minSdk.get().toInt()
                    targetSdk = verLibs.versions.targetSdk.get().toInt()
                    buildToolsVersion = verLibs.versions.buildToolsVersion.get()
                    versionCode = verLibs.versions.versionCode.get().toInt()
                    versionName = verLibs.versions.versionName.get()
                }
            }
        }
    }
}