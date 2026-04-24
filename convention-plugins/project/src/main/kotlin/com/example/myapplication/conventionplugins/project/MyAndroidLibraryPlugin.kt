package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.project.extentions.applyCommonPlugins
import com.example.myapplication.conventionplugins.project.extentions.configureCommonParameters
import com.example.myapplication.conventionplugins.project.extentions.verLibs
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyAndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(verLibs.plugins.androidLibrary.get().pluginId)
            applyCommonPlugins()
            configureCommonParameters()
        }
    }
}
