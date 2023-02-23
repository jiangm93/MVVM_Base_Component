package com.jiangm.mvvm.lib.base

import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.jiangm.mvvm.lib.base.app.LoadModuleProxy
import kotlinx.coroutines.MainScope

/**
 *
 *@date：2023/2/23 11:02
 *@author: jiangm
 *@version: 1.0
 *@desc: 描述
 *
 */
class BaseApplication : MultiDexApplication() {

    private val mCoroutineScope by lazy(mode = LazyThreadSafetyMode.NONE) { MainScope() }

    private val mLoadModuleProxy by lazy(mode = LazyThreadSafetyMode.NONE) { LoadModuleProxy() }

    companion object {
        // 全局Context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var application: BaseApplication
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
        application = this
        mLoadModuleProxy.onAttachBaseContext(base)
    }
}