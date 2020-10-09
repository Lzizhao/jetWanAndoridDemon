package com.example.jpwanandroiddemon.bean

/**
 * Created by Admin on 2020-10-09
 */
data class BannerBean(
    var errorCode: Int,
    var errorMsg: String,
    var data: List<Data>
) {
    data class Data(
        var desc: String,
        var id: Int,
        var imagePath: String,
        var isVisible: Int,
        var order: Int,
        var title: String,
        var type: Int,
        var url: String
    )
}