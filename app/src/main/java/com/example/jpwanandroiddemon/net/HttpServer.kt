package com.example.jpwanandroiddemon.net

import com.example.jpwanandroiddemon.bean.ApiPagerResponse
import com.example.jpwanandroiddemon.bean.AriticleResponse
import com.example.jpwanandroiddemon.bean.BannerBean
import com.example.jpwanandroiddemon.bean.base.ApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

open interface HttpServer {

    /**
     * 获取首页Banner
     */
    @GET("banner/json")
    fun getBanner(): Observable<BannerBean>


    /**
     * 获取首页文章数据
     */
    @GET("/article/list/{page}/json")
    fun getAritrilList(@Path("page") pageNo: Int): Observable<ApiResponse<ApiPagerResponse<MutableList<AriticleResponse>>>>

}
