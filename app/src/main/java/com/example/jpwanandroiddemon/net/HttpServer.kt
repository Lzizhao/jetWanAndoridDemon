package com.example.jpwanandroiddemon.net

import com.example.jpwanandroiddemon.bean.BannerBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

open interface HttpServer {

    @GET("banner/json")
    fun getBanner(): Observable<BannerBean>;

}
