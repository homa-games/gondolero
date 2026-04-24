package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.project.extentions.applyCommonPlugins
import com.example.myapplication.conventionplugins.project.extentions.configureCommonParameters
import com.example.myapplication.conventionplugins.project.extentions.myAndroidAppConfig
import com.example.myapplication.conventionplugins.project.extentions.verLibs
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyAndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(verLibs.plugins.androidApplication.get().pluginId)
            applyCommonPlugins()
            configureCommonParameters()
            myAndroidAppConfig {
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
