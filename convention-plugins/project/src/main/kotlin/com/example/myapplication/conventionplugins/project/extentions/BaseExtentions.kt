package com.example.myapplication.conventionplugins.project.extentions

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.ProductFlavor
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

private typealias CommonAndroidExtension = CommonExtension<
        out BuildFeatures,
        out BuildType,
        out DefaultConfig,
        out ProductFlavor,
        out AndroidResources,
        out Installation>

private val Project.libExt: LibraryExtension
    get() = extensions.findByType(LibraryExtension::class)
        ?: error(
            "\"Project.libExt\" value may be called only from android library gradle script"
        )

private val Project.appExt: BaseAppModuleExtension
    get() = extensions.findByType(BaseAppModuleExtension::class)
        ?: error(
            "\"Project.appExt\" value may be called only from android application gradle script"
        )

private val Project.commonExt: CommonAndroidExtension
    get() = extensions.findByType(BaseAppModuleExtension::class)
        ?: extensions.findByType(LibraryExtension::class)
        ?: error(
            "\"Project.commonExt\" value may be called only from android application or library gradle script"
        )

val Project.verLibs: LibrariesForLibs
    get() = extensions.getByType(LibrariesForLibs::class)

fun Project.myAndroidLibConfig(block: LibraryExtension.() -> Unit): Unit {
    block(libExt)
}

fun Project.myAndroidAppConfig(block: BaseAppModuleExtension.() -> Unit): Unit {
    block(appExt)
}

fun Project.myCommonAndroidConfig(block: CommonAndroidExtension.() -> Unit): Unit {
    block(commonExt)
}

fun Project.myKotlinOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions(block)
    }
}
