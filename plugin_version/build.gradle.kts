plugins {
    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    //添加Gradle相关的API，否则无法自定义Plugin和Task
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
}

gradlePlugin {
    plugins {
        create("version") {
            //添加插件
            id = "com.jiangm.plugin.version"
            version = "1.0.0"
            //在根目录创建类 VersionPlugin 继承 Plugin<Project>
            implementationClass = "com.jiangm.plugin.version.VersionPlugin"
        }

    }
}
