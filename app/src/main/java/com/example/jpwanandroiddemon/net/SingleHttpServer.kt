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
        var httpServer:HttpServer? = null
        fun getInstance():HttpServer{
            if (httpServer==null) {
                httpServer = HttpConfig.create()
            }
            return httpServer!!
        }
    }

}