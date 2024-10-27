package com.example.myapplication.base.extensions

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

private val Project.libExt: LibraryExtension
    get() = extensions.findByType(LibraryExtension::class.java)
        ?: error(
            "\"Project.libExt\" value may be called only from android library gradle script"
        )

private val Project.appExt: BaseAppModuleExtension
    get() = extensions.findByType(BaseAppModuleExtension::class.java)
        ?: error(
            "\"Project.appExt\" value may be called only from android application gradle script"
        )

val Project.verLibs: LibrariesForLibs
    get() = extensions.getByType(LibrariesForLibs::class.java)

fun Project.myAndroidLibConfig(block: LibraryExtension.() -> Unit): Unit {
    block(libExt)
}

fun Project.myAndroidAppConfig(block: BaseAppModuleExtension.() -> Unit): Unit {
    block(appExt)
}

fun Project.myKotlinOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}
