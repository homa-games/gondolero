package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.project.extentions.myCommonAndroidConfig
import com.example.myapplication.conventionplugins.project.extentions.myKotlinOptions
import com.example.myapplication.conventionplugins.project.extentions.verLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

class MyCompileOptionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            myCommonAndroidConfig {
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
