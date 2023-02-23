package com.jiangm.mvvm.lib.base.utils
import android.content.pm.PackageInfo
import android.os.Build
import com.jiangm.mvvm.lib.base.BaseApplication

/**
 * App 相关工具类
 */
class AppUtils {

    /**
     * 获取当前 App 版本号
     *
     * @return Long
     */
    fun getAppVersionCode(): Long {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getAppPackageInfo().longVersionCode
        } else {
            getAppPackageInfo().versionCode.toLong()
        }
    }

    /**
     * 获取当前 App 版本名
     *
     * @return String
     */
    fun getAppVersionName(): String = getAppPackageInfo().versionName

    /**
     * 获取当前 App 的 [PackageInfo]
     *
     * @return PackageInfo
     */
    fun getAppPackageInfo(): PackageInfo {
        return BaseApplication.context
            .packageManager
            .getPackageInfo(BaseApplication.context.packageName, 0)
    }
}