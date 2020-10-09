package com.example.jpwanandroiddemon.net

import android.util.Log
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KParameter

/**
 * <pre>
 *     author: zhuangzw@anjiu-tech.com
 *     time  : 2020/9/29
 *     desc  : Http 配置
 * </pre>
 */
object HttpConfig {

    private const val BASE_API: String = "https://www.wanandroid.com/";

    fun create(): HttpServer {
        val retrofit = Retrofit.Builder()
                .client(getHttpClient())
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        return retrofit.create(HttpServer::class.java)
    }

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message: String? -> Log.e("HLI", message) })
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(logging)
                .connectTimeout(20000, TimeUnit.MILLISECONDS)
                .readTimeout(20000, TimeUnit.MILLISECONDS)
                .writeTimeout(20000, TimeUnit.MILLISECONDS)
//                .addInterceptor(YYInterceptor())
//                .addInterceptor(StatusInterceptor())
                .build()
    }
}