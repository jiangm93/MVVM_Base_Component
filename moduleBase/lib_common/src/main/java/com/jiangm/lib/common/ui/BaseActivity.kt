package com.jiangm.lib.common.ui

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.jiangm.mvvm.lib.base.mvvm.v.BaseFrameActivity
import com.jiangm.mvvm.lib.base.mvvm.vm.BaseViewModel
import com.jiangm.mvvm.lib.base.utils.ActivityStackManager
import com.jiangm.mvvm.lib.base.utils.AndroidBugFixUtils
import com.jiangm.mvvm.lib.base.utils.BarUtils


/**
 * Activity基类
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : BaseFrameActivity<VB, VM>() {

    /**
     * 设置状态栏
     * 子类需要自定义时重写该方法即可
     * @return Unit
     */
    override fun setStatusBar() {
        BarUtils.transparentStatusBar(this)
        BarUtils.setStatusBarLightMode(this, true)
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "ActivityStack: ${ActivityStackManager.activityStack}")
    }

    override fun onDestroy() {
        super.onDestroy()
        // 解决某些特定机型会触发的Android本身的Bug
        AndroidBugFixUtils().fixSoftInputLeaks(this)
    }
}