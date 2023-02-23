import kotlin.concurrent.timerTask

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven ("https://maven.aliyun.com/nexus/content/groups/public/")
        maven ("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven ("https://maven.aliyun.com/nexus/content/repositories/google")
        maven ("https://maven,aliyun,com/nexus/content/repositories/gradle-plugin")
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven ("https://maven.aliyun.com/nexus/content/groups/public/")
        maven ("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven ("https://maven.aliyun.com/nexus/content/repositories/google")
        maven ("https://maven,aliyun,com/nexus/content/repositories/gradle-plugin")
        maven("https://jitpack.io")
    }
}
rootProject.name = "MVVM_Base_Component"
include(":app")
includeBuild("plugin_version")
include(":moduleBase:lib_base")
include(":moduleBase:lib_common")
