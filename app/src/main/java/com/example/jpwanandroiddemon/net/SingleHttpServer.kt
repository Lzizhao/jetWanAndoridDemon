package com.example.jpwanandroiddemon.net

/**
 * <pre>
 *     author: luozz@anjiu-tech.com
 *     time  : 2020/10/9
 *     desc  :
 * </pre>
 */
class SingleHttpServer private constructor(){

    companion object{


        fun getInstance():HttpServer{
            return HttpConfig.create()
        }
    }

}