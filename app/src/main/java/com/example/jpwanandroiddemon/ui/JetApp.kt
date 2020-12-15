package com.example.jpwanandroiddemon.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.multidex.MultiDex
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.EmptyCallback
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.ErrorCallback
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.LoadingCallback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir


/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/9/28
 *     desc  :
 * </pre>
 */
class JetApp :Application(),ViewModelStoreOwner{
    private lateinit var mAppModelStore: ViewModelStore
    private var mFactory: ViewModelProvider.Factory? = null

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)




        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()
    }


    fun getAppProvider():ViewModelProvider{
        return ViewModelProvider(this,this.getAppModelFactory())
    }

    private fun getAppModelFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory!!
    }

    override fun getViewModelStore(): ViewModelStore {
        return mAppModelStore
    }
}