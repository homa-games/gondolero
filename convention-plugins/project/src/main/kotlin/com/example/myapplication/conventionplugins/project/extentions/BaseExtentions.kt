package com.example.myapplication.conventionplugins.project.extentions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

private val Project.libExt: LibraryExtension
    get() = extensions.findByType(LibraryExtension::class)
        ?: error("\"Project.libExt\" value may be called only from android library gradle script")

private val Project.appExt: ApplicationExtension
    get() = extensions.findByType(ApplicationExtension::class)
        ?: error(
            "\"Project.appExt\" value may be called only from android application gradle script",
        )

private val Project.commonExt: CommonExtension
    get() = extensions.findByType(ApplicationExtension::class)
        ?: extensions.findByType(LibraryExtension::class)
        ?: error(
            "\"Project.commonExt\" value may be called only from android application or library gradle script",
        )

val Project.verLibs: LibrariesForLibs
    get() = extensions.getByType(LibrariesForLibs::class)

fun Project.myAndroidLibConfig(block: LibraryExtension.() -> Unit) {
    block(libExt)
}

fun Project.myAndroidAppConfig(block: ApplicationExtension.() -> Unit) {
    block(appExt)
}

fun Project.myCommonConfig(block: CommonExtension.() -> Unit) {
    block(commonExt)
}

fun Project.myKotlinOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}

fun Project.applyCommonPlugins() {
    pluginManager.apply("myOptions.compiler.plugin")
    pluginManager.apply("myKtlint.linter.plugin")
}

fun Project.configureCommonParameters() {
    myCommonConfig {
        compileSdk = verLibs.versions.compileSdk.get().toInt()
    }
}
