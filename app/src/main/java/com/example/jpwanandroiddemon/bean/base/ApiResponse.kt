package com.example.jpwanandroiddemon.bean.base

import java.io.Serializable
/**
 * 基类
 */
open class ApiResponse<T>(var data: T, var errorCode: Int, var errorMsg: String) : Serializable {
    fun isSucces(): Boolean {
        return errorCode == 0
    }
}