import com.example.myapplication.conventionplugins.base.extensions.myAndroidLibConfig
import com.example.myapplication.conventionplugins.base.extensions.myKotlinOptions
import com.example.myapplication.conventionplugins.base.extensions.verLibs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

myAndroidLibConfig {
    compileSdk = verLibs.versions.compileSdk.get().toInt()

    val javaVer = JavaVersion.toVersion(verLibs.versions.java.get().toInt())
    compileOptions {
        sourceCompatibility = javaVer
        targetCompatibility = javaVer
    }

    myKotlinOptions {
        jvmTarget = JvmTarget.fromTarget(javaVer.toString())
    }
}
