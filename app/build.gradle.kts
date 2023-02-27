import com.jiangm.plugin.version.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AndroidConfig.namespace
    compileSdk = AndroidConfig.compileSdk
    buildToolsVersion = AndroidConfig.buildToolsVersion

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    if (!AndroidConfig.isAppMode) {
        // 有业务组件时 把这个去掉 这里只是为了使用base里的依赖库
        implementation(project(":moduleCore:main"))
    } else {
        implementation(project(":moduleBase:lib_common"))
    }
    implementation(DependencyConfig.JetPack.HiltCore)

    kapt(DependencyConfig.GitHub.AutoServiceAnnotations)
    kapt(DependencyConfig.JetPack.HiltApt)

//    implementation (DependencyConfig.AndroidX.CoreKtx)
//    implementation (DependencyConfig.AndroidX.AppCompat)
//    implementation (DependencyConfig.Android.Material)
//    implementation (DependencyConfig.AndroidX.ConstraintLayout)
//    testImplementation (DependencyConfig.Android.Junit)
//    androidTestImplementation (DependencyConfig.AndroidX.TestExtJunit)
//    androidTestImplementation (DependencyConfig.AndroidX.TestEspresso)

}