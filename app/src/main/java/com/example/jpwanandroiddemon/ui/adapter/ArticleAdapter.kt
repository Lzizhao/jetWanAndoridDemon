package com.example.jpwanandroiddemon.ui.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.jpwanandroiddemon.R
import com.example.jpwanandroiddemon.bean.AriticleResponse


class ArticleAdapter(data: MutableList<AriticleResponse>?) :
    BaseQuickAdapter<AriticleResponse, BaseViewHolder>(R.layout.item_ariticle, data) {


    override fun convert(helper: BaseViewHolder, item: AriticleResponse?) {

        //文章布局的赋值
        item?.run {
            helper.setText(R.id.item_home_author, if (author.isNotEmpty()) author else shareUser)
            helper.setText(R.id.item_home_content, Html.fromHtml(title))
            helper.setText(R.id.item_home_type2, Html.fromHtml("$superChapterName·$chapterName"))
            helper.setText(R.id.item_home_date, niceDate)
//            helper.getView<CollectView>(R.id.item_home_collect).isChecked = collect
//            if (showTag) {
//                //展示标签
//                helper.setGone(R.id.item_home_new, fresh)
//                helper.setGone(R.id.item_home_top, type == 1)
//                if (tags.isNotEmpty()) {
//                    helper.setGone(R.id.item_home_type1, true)
//                    helper.setText(R.id.item_home_type1, tags[0].name)
//                } else {
//                    helper.setGone(R.id.item_home_type1, false)
//                }
//            } else {
//                //隐藏所有标签
//                helper.setGone(R.id.item_home_top, false)
//                helper.setGone(R.id.item_home_type1, false)
//                helper.setGone(R.id.item_home_new, false)
//            }
//        }
//        helper.getView<CollectView>(R.id.item_home_collect)
//            .setOnCollectViewClickListener(object : CollectView.OnCollectViewClickListener {
//                override fun onClick(v: CollectView) {
//                    mOnCollectViewClickListener?.onClick(helper, v, helper.adapterPosition)
//                }
//            })
//        helper.getView<TextView>(R.id.item_home_author).setOnClickListener {
//            if (clickable) {
//                mContext.startActivity(Intent(mContext, ShareByIdActivity::class.java).apply {
//                    putExtra("id", item?.userId)
//                })
//            }
        }
    }

}


