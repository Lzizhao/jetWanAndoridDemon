package com.example.jpwanandroiddemon.ui

import android.app.Application
import androidx.multidex.MultiDex

/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/9/28
 *     desc  :
 * </pre>
 */
class JetApp :Application(){


    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

}