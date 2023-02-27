package com.jiangm.plugin.version

/**
 * @date：2023/2/18 9:14
 * @author: jiangm
 * @version: 1.0
 * @desc: 描述
 */
object AndroidConfig {
    const val namespace = "com.jiangm.mbc"
    const val applicationId = "com.jiangm.mbc"
    const val compileSdk = 33
    const val buildToolsVersion = "30.0.3"
    const val minSdk = 28
    const val targetSdk = 30
    const val versionCode = 1000000
    const val versionName = "1.0.0.0"
    const val isAppMode = false

    object Version {

        const val RELEASE = "VERSION_STATUS_RELEASE"

        const val ALPHA = "VERSION_STATUS_ALPHA"

        const val BETA = "VERSION_STATUS_BETA"
    }
}