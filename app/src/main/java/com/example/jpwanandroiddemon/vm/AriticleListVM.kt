package com.example.jpwanandroiddemon.vm

import com.example.jpwanandroiddemon.bean.ApiPagerResponse
import com.example.jpwanandroiddemon.bean.AriticleResponse
import com.example.jpwanandroiddemon.bean.base.ApiResponse
import com.example.jpwanandroiddemon.net.SingleHttpServer
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/10/9
 *     desc  :
 * </pre>
 */
class AriticleListVM : BaseVM<ApiResponse<ApiPagerResponse<MutableList<AriticleResponse>>>>() {



    fun getAriticleList(page:Int){
        SingleHttpServer.getInstance()
            .getAritrilList(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                setData(it)
            }) {

            }
    }


}