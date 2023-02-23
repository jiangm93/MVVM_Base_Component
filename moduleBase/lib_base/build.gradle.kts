import com.jiangm.plugin.version.*

plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.jiangm.plugin.version")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.jiangm.mvvm.lib.base"
    compileSdk = AndroidConfig.compileSdk
    buildToolsVersion = AndroidConfig.buildToolsVersion
    resourcePrefix="base_"

    defaultConfig {

        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = DependencyConfig.AndroidX.AndroidJUnitRunner
        consumerProguardFiles("consumer-rules.pro")

//        ndk {
//            // 设置支持的SO库架构
//            //abiFilters 'armeabi', 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
////            abiFilters("armeabi-v7a", "arm64-v8a", "x86")
//            abiFilters
////            abiFilters("armeabi-v7a", "arm64-v8a", "x86")
//        }
    }
    splits {

        // Configures multiple APKs based on ABI.
        abi {

            // Enables building multiple APKs per ABI.
            isEnable = true

            // By default all ABIs are included, so use reset() and include to specify that we only
            // want APKs for x86 and x86_64.

            // Resets the list of ABIs that Gradle should create APKs for to none.
            reset()

            // Specifies a list of ABIs that Gradle should create APKs for.
            include("armeabi-v7a", "arm64-v8a", "x86")

            // Specifies that we do not want to also generate a universal APK that includes all ABIs.
            isUniversalApk = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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
    buildFeatures {
        viewBinding = true
    }


}


dependencies {

    api(DependencyConfig.AndroidX.CoreKtx)
    api(DependencyConfig.AndroidX.AppCompat)
    api(DependencyConfig.AndroidX.ConstraintLayout)
    api(DependencyConfig.AndroidX.ActivityKtx)
    api(DependencyConfig.AndroidX.FragmentKtx)
    api(DependencyConfig.AndroidX.MultiDex)

    api(DependencyConfig.Android.Material)

    api(DependencyConfig.Kotlin.Kotlin)
    api(DependencyConfig.Kotlin.CoroutinesCore)
    api(DependencyConfig.Kotlin.CoroutinesAndroid)

    api(DependencyConfig.JetPack.ViewModel)
    api(DependencyConfig.JetPack.ViewModelSavedState)
    api(DependencyConfig.JetPack.LiveData)
    api(DependencyConfig.JetPack.Lifecycle)
    api(DependencyConfig.JetPack.HiltCore)

    api(DependencyConfig.GitHub.Gson)
    api(DependencyConfig.GitHub.MMKV)
    api(DependencyConfig.GitHub.AutoSize)
    api(DependencyConfig.GitHub.ARoute)
    api(DependencyConfig.GitHub.RecyclerViewAdapter)
    api(DependencyConfig.GitHub.EventBus)
    api(DependencyConfig.GitHub.PermissionX)
    api(DependencyConfig.GitHub.AutoService)
    api(DependencyConfig.GitHub.OkHttp)
    api(DependencyConfig.GitHub.OkHttpInterceptorLogging)
    api(DependencyConfig.GitHub.Retrofit)
    api(DependencyConfig.GitHub.RetrofitConverterGson)
    api(DependencyConfig.GitHub.Coil)
    api(DependencyConfig.GitHub.CoilGIF)
    api(DependencyConfig.GitHub.CoilSVG)
    api(DependencyConfig.GitHub.CoilVideo)

    api(DependencyConfig.SDK.TencentBugly)
    api(DependencyConfig.SDK.TencentBuglyNative)
    api(DependencyConfig.SDK.TencentTBSX5)

    kapt(DependencyConfig.GitHub.ARouteCompiler)
    kapt(DependencyConfig.GitHub.EventBusAPT)
    kapt(DependencyConfig.GitHub.AutoServiceAnnotations)
    kapt(DependencyConfig.JetPack.HiltApt)
    kapt(DependencyConfig.JetPack.LifecycleCompilerAPT)

    debugApi(DependencyConfig.GitHub.LeakCanary)

}
kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
    }
}