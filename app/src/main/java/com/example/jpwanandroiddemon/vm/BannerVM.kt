package com.example.jpwanandroiddemon.vm

import com.example.jpwanandroiddemon.bean.BannerBean
import com.example.jpwanandroiddemon.net.SingleHttpServer
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/10/9
 *     desc  :
 * </pre>
 */
class BannerVM : BaseVM<BannerBean>() {


    fun getBanner() {
        SingleHttpServer.getInstance()
            .getBanner()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                setData(it)
            }
    }



}