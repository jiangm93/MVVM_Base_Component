package com.jiangm.mbc

import com.jiangm.mvvm.lib.base.BaseApplication
import dagger.hilt.android.HiltAndroidApp
import org.greenrobot.eventbus.EventBus

/**
 *
 *@date：2023/2/24 14:37
 *@author: jiangm
 *@version: 1.0
 *@desc: 描述
 *
 */
@HiltAndroidApp
class DemoApplication :BaseApplication()  {
    override fun onCreate() {
        super.onCreate()
        EventBus.builder()
//            .addIndex()
            .installDefaultEventBus()
    }
}