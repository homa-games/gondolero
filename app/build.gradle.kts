import com.example.myapplication.conventionplugins.base.extensions.myAndroidAppConfig
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("myAndroid.application.plugin")
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ktlintGradle)
}

myAndroidAppConfig {
    namespace = "com.example.myapplication"

    defaultConfig {
        applicationId = "com.example.myapplication"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(project(":features:demo:impl"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.ui.tooling)
    ktlintRuleset(libs.compose.rules)
}

ktlint {
    version = libs.versions.ktlintCli
    enableExperimentalRules = false
    ignoreFailures = false
    reporters {
        reporter(ReporterType.PLAIN_GROUP_BY_FILE)
        reporter(ReporterType.HTML)
    }
}
