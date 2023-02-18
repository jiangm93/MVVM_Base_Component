import com.jiangm.plugin.version.*
plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.jiangm.plugin.version")
}

android {
    namespace = AndroidConfig.namespace
    compileSdk = AndroidConfig.compileSdk
    buildToolsVersion =AndroidConfig.buildToolsVersion

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
       getByName("release"){
            isMinifyEnabled=false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation (Libs.coreKtx)
    implementation (Libs.appcompat)
    implementation (Libs.material)
    implementation (Libs.constraintlayout)
    testImplementation (Libs.junit)
    androidTestImplementation (Libs.testExt)
    androidTestImplementation (Libs.testEspresso)
}