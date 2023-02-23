////****************************************
////********* module模块的公共脚本配置 **********
////****************************************
//import com.jiangm.plugin.version.*
//
//apply(plugin = "com.android.library")
//apply(plugin = "kotlin-android")
//apply(plugin = "kotlin-kapt")
////apply(plugin = "dagger.hilt.android.plugin")
//apply(plugin = "com.jiangm.plugin.version")
//
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
//        testInstrumentationRunner = DependencyConfig.AndroidX.AndroidJUnitRunner
//
//
//        ndk {
//            // 设置支持的SO库架构
//            //abiFilters 'armeabi', 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
//            abiFilters("armeabi-v7a", "arm64-v8a", "x86")
//        }
//    }
//
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//
//    buildFeatures {
//        viewBinding = true
//    }
//    sourceSets {
//        main {
//            manifest.srcFile("src/main/AndroidManifest.xml")
//            java {
//                //排除debug文件夹下的所有文件
//                exclude("debug/**")
//            }
//        }
//    }
//
//    buildTypes {
//        // 对应 ALPHA 版本
//        getByName("debug") {
//            buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.ALPHA}\"")
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//        getByName("beta") {
//            buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.BETA}\"")
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//        getByName("release") {
//            buildConfigField("String", "VERSION_TYPE", "\"${AndroidConfig.Version.RELEASE}\"")
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//
//    }
//}
//
//kapt {
//    arguments {
//        arg("AROUTER_MODULE_NAME", project.name)
//        arg(
//            "eventBusIndex",
//            "${ProjectBuildConfig.applicationId}.eventbus.index.${project.name}EventIndex"
//        )
//    }
//}
//
//dependencies {
//    implementation fileTree (dir: "libs", include: ["*.jar"])
//
//    api project (path: ":lib_common")
//
//    testImplementation(DependencyConfig.Android.Junit)
//    androidTestImplementation(DependencyConfig.AndroidX.TestExtJunit)
//    androidTestImplementation(DependencyConfig.AndroidX.TestEspresso)
//    implementation(DependencyConfig.JetPack.HiltCore)
//
//    kapt(DependencyConfig.GitHub.ARouteCompiler)
//    kapt(DependencyConfig.GitHub.EventBusAPT)
//    kapt(DependencyConfig.GitHub.AutoServiceAnnotations)
//    kapt(DependencyConfig.JetPack.HiltApt)
//    kapt(DependencyConfig.JetPack.LifecycleCompilerAPT)
//}