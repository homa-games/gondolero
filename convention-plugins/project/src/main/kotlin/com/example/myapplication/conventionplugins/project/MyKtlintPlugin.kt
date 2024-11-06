package com.example.myapplication.conventionplugins.project

import com.example.myapplication.conventionplugins.project.extentions.verLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class MyKtlintPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(verLibs.plugins.ktlintGradle.get().pluginId)
            }
            configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
                version = verLibs.versions.ktlintCli
                enableExperimentalRules = false
                ignoreFailures = false
                reporters {
                    reporter(ReporterType.PLAIN_GROUP_BY_FILE)
                    reporter(ReporterType.HTML)
                }
            }
        }
    }
}
