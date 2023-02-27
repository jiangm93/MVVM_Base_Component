// Top-level build file where you can add configuration options common to all sub-projects/modules.
//引入公共gradle文件配置
//apply(from = "${project.projectDir.path}/base_lib.gradle.kts")
plugins {
    id ("com.android.application") version "7.4.1" apply false
    id ("com.android.library") version "7.4.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.jiangm.plugin.version") version "1.0.0" apply false
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
