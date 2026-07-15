pluginManagement {
    includeBuild("convention-plugins/project")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
plugins {
    id("com.android.settings") version "9.2.1"
}

rootProject.name = "My Application"
include(":app")
include(":features:demo:api")
include(":features:demo:impl")
