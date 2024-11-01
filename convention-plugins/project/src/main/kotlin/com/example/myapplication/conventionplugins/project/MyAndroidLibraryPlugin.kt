package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.base.extensions.verLibs
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyAndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(verLibs.plugins.androidLibrary.get().pluginId)
                apply(verLibs.plugins.jetbrainsKotlinAndroid.get().pluginId)
                apply("androidLib.base.config")
            }
        }
    }
}