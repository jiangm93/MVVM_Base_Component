import com.jiangm.plugin.version.*


plugins {
//    id(if( AndroidConfig.isAppMode) "com.android.application" else "com.android.library")
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.jiangm.module.main"
    compileSdk = AndroidConfig.compileSdk
    buildToolsVersion = AndroidConfig.buildToolsVersion
    resourcePrefix = "main_"
    defaultConfig {
//        applicationId = "com.jiangm.module.main"
//        versionCode = AndroidConfig.versionCode
//        versionName = AndroidConfig.versionName
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = DependencyConfig.AndroidX.AndroidJUnitRunner

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
//        compose = true
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
}

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg(
            "eventBusIndex",
            "${AndroidConfig.applicationId}.eventbus.index.${project.name}EventIndex"
        )
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(project(":moduleBase:lib_common"))

    testImplementation(DependencyConfig.Android.Junit)
    androidTestImplementation(DependencyConfig.AndroidX.TestExtJunit)
    androidTestImplementation(DependencyConfig.AndroidX.TestEspresso)
    implementation(DependencyConfig.JetPack.HiltCore)

    kapt(DependencyConfig.GitHub.ARouteCompiler)
    kapt(DependencyConfig.GitHub.EventBusAPT)
    kapt(DependencyConfig.GitHub.AutoServiceAnnotations)
    kapt(DependencyConfig.JetPack.HiltApt)
    kapt(DependencyConfig.JetPack.LifecycleCompilerAPT)
}
