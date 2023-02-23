////****************************************
////********* lib 模块的公共脚本配置 **********
////****************************************
//import com.jiangm.plugin.version.*
//
//apply(plugin = "com.android.library")
//apply(plugin = "org.jetbrains.kotlin.android")
//apply(kotlin = "kapt")
//apply(plugin = "com.google.dagger.hilt.android")
//apply(plugin = "com.jiangm.plugin.version")
////plugins {
////    kotlin("kapt")
////    id("com.android.library")
////    id("org.jetbrains.kotlin.android")
////    id("com.jiangm.plugin.version")
////    id("com.google.dagger.hilt.android")
////}
//android {
//    namespace = AndroidConfig.namespace
//    compileSdk = AndroidConfig.compileSdk
//    buildToolsVersion = AndroidConfig.buildToolsVersion
//
//    defaultConfig {
//
//        minSdk = AndroidConfig.minSdk
//        targetSdk = AndroidConfig.targetSdk
//        versionCode = AndroidConfig.versionCode
//        versionName = AndroidConfig.versionName
//
//        testInstrumentationRunner = DependencyConfig.AndroidX.AndroidJUnitRunner
//        consumerProguardFiles("consumer-rules.pro")
//
//        ndk {
//            // 设置支持的SO库架构
//            //abiFilters 'armeabi', 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
//            abiFilters("armeabi-v7a", "arm64-v8a", "x86")
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//
//
//    buildTypes {
//        // 对应 ALPHA 版本
//        getByName("debug") {
//            buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.ALPHA}\"")
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
//            )
//        }
//        getByName("beta") {
//            buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.BETA}\"")
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
//            )
//        }
//        getByName("release") {
//            buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.RELEASE}\"")
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
//            )
//        }
//
//    }
//}
//
//kapt {
//    arguments {
//        arg("AROUTER_MODULE_NAME", project.getName())
//    }
//}