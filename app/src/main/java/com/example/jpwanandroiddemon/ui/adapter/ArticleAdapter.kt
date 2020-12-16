package com.example.jpwanandroiddemon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.jpwanandroiddemon.bean.AriticleResponse
import com.example.jpwanandroiddemon.databinding.ItemAriticleBinding
import com.example.jpwanandroiddemon.ui.adapter.viewholder.ArticleViewHolder


class ArticleAdapter(data: MutableList<AriticleResponse>?) :
    BaseQuickAdapter<AriticleResponse, BaseViewHolder>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ArticleViewHolder(ItemAriticleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun convert(helper: BaseViewHolder, item: AriticleResponse?) {
        val articleViewHolder = helper as ArticleViewHolder
        articleViewHolder.setDatas(item)
    }
}




