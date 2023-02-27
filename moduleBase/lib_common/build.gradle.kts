import com.jiangm.plugin.version.*

plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
//    id("com.jiangm.plugin.version")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jiangm.lib.common"
    compileSdk = AndroidConfig.compileSdk
    buildToolsVersion = AndroidConfig.buildToolsVersion
    resourcePrefix = "common_"

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = DependencyConfig.AndroidX.AndroidJUnitRunner
        consumerProguardFiles("consumer-rules.pro")
        resValue("string", "BUGLY_APP_ID", SDKKeyConfig.BUGLY_APP_ID)
    }

        buildTypes {
            // 对应 ALPHA 版本
            getByName("debug") {
                buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.ALPHA}\"")
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

            getByName("release") {
                buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.RELEASE}\"")
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }

        }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(":moduleBase:lib_base"))
    api(DependencyConfig.JetPack.HiltCore)
    kapt(DependencyConfig.GitHub.ARouteCompiler)
    kapt(DependencyConfig.GitHub.EventBusAPT)
    kapt(DependencyConfig.GitHub.AutoServiceAnnotations)
    kapt(DependencyConfig.JetPack.HiltApt)
    kapt(DependencyConfig.JetPack.LifecycleCompilerAPT)
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
    }
}