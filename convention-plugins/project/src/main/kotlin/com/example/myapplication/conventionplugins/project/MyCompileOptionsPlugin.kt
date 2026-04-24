package com.example.myapplication.conventionplugins.project

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.example.myapplication.conventionplugins.project.extentions.myKotlinOptions
import com.example.myapplication.conventionplugins.project.extentions.verLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

class MyCompileOptionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val javaVer = JavaVersion.toVersion(verLibs.versions.java.get().toInt())
            extensions.findByType(ApplicationExtension::class)?.compileOptions {
                sourceCompatibility = javaVer
                targetCompatibility = javaVer
            }
            extensions.findByType(LibraryExtension::class)?.compileOptions {
                sourceCompatibility = javaVer
                targetCompatibility = javaVer
            }
            myKotlinOptions {
                jvmTarget = JvmTarget.fromTarget(javaVer.toString())
            }
        }
    }
}
