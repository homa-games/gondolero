import com.example.myapplication.base.extensions.myAndroidAppConfig
import com.example.myapplication.base.extensions.myKotlinOptions
import com.example.myapplication.base.extensions.verLibs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

myAndroidAppConfig {
    compileSdk = verLibs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = verLibs.versions.minSdk.get().toInt()
        targetSdk = verLibs.versions.targetSdk.get().toInt()
        buildToolsVersion = verLibs.versions.buildToolsVersion.get()
    }
    val javaVer = JavaVersion.toVersion(verLibs.versions.java.get().toInt())
    compileOptions {
        sourceCompatibility = javaVer
        targetCompatibility = javaVer
    }
    myKotlinOptions {
        jvmTarget = JvmTarget.fromTarget(javaVer.toString())
    }
}
