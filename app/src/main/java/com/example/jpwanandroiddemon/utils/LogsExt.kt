package com.example.jpwanandroiddemon.utils

import android.util.Log


/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/12/16
 *     desc  :
 * </pre>
 */
const val TAG = "LogsExt"
const val DEBUG: Boolean = true


fun String.logv(tag: String = TAG) {
    log(Log.VERBOSE, tag,this)
}

fun String.logd(tag: String = TAG) {
    log(Log.DEBUG, tag,this)
}

fun String.loge(tag: String = TAG) {
    log(Log.DEBUG, tag,this)
}


private fun log(level: Int,tag: String,message:String) {
    if (DEBUG) {
        when (level) {
            Log.VERBOSE -> Log.v(tag, message)
            Log.DEBUG -> Log.d(tag, message)
            Log.ERROR -> Log.e(tag, message)
        }
    }
}




