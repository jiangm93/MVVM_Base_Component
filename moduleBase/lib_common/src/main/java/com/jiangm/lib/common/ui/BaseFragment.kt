package com.jiangm.lib.common.ui

import androidx.viewbinding.ViewBinding
import com.jiangm.mvvm.lib.base.mvvm.v.BaseFrameFragment
import com.jiangm.mvvm.lib.base.mvvm.vm.BaseViewModel

/**
 * Fragment基类
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : BaseFrameFragment<VB, VM>()