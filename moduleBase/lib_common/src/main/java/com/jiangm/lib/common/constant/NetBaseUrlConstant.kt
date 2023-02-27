package com.jiangm.lib.common.constant

/**
 * 接口公共地址
 */
internal object NetBaseUrlConstant {

    val MAIN_URL = "http://www.baidu.com"
    get() {
        if (field.isEmpty()){
            throw NotImplementedError("请求改你的 MAIN_URL 的值为自己的请求地址")
        }
       return  field
    }
}