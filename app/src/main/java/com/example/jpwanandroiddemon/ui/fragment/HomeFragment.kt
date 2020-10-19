package com.example.jpwanandroiddemon.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.example.jpwanandroiddemon.R
import com.example.jpwanandroiddemon.bean.BannerBean
import com.example.jpwanandroiddemon.databinding.FragmentHomeBinding
import com.example.jpwanandroiddemon.ui.adapter.ArticleAdapter
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.EmptyCallback
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.ErrorCallback
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.LoadingCallback
import com.example.jpwanandroiddemon.ui.main.HomeViewModel
import com.example.jpwanandroiddemon.vm.AriticleListVM
import com.example.jpwanandroiddemon.vm.BannerVM
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.include_banner.view.*
import kotlinx.android.synthetic.main.include_recyclerview.view.*
import me.yokeyword.fragmentation.SupportFragment

class HomeFragment : SupportFragment() {

    companion object {
        fun newInstance() =
            HomeFragment()
    }

    private var mPage = 0


    private lateinit var mViewModel: HomeViewModel
    private lateinit var mLoadSir: LoadService<Any>
    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mBannerVM: BannerVM
    private lateinit var mArticleListVM: AriticleListVM
    private lateinit var mArticleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)//加上这句话，menu才会显示出来
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        FragmentHomeBinding.inflate(layoutInflater)


        mArticleAdapter = ArticleAdapter(mutableListOf())
        mBinding.root.swiperecyclerview.adapter = mArticleAdapter
        mBinding.root.swiperecyclerview.layoutManager = LinearLayoutManager(_mActivity)

        // TODO: Use the ViewModel
        mBannerVM = ViewModelProvider(this).get<BannerVM>(BannerVM::class.java)
        mArticleListVM = ViewModelProvider(this).get<AriticleListVM>(AriticleListVM::class.java)
        initData();
        initListen();
    }

    private fun initListen() {
        mBinding.root.swiperecyclerview.setLoadMoreListener {
            mArticleListVM.getAriticleList(mPage++)
        }
    }

    private fun initData() {
//        mLoadSir = LoadSir.getDefault().register(
//            mBinding.root.findViewById(R.id.swipeRefreshLayout),
//            Callback.OnReloadListener {
//                mLoadSir.showCallback(LoadingCallback::class.java)
//            })
//        mLoadSir.showCallback(EmptyCallback::class.java)


        mBannerVM.data.observe(viewLifecycleOwner, Observer {
            if (it.errorCode == 0) {
//                mLoadSir.showSuccess()
//                requestBannerSucces(it.data)
            } else {
                mLoadSir.showCallback(ErrorCallback::class.java)
                Toast.makeText(activity, it.errorMsg, Toast.LENGTH_SHORT).show()
            }
        })

        mArticleListVM.data.observe(viewLifecycleOwner, Observer {
            mArticleAdapter.setNewData(it.data.datas)
            mArticleAdapter.notifyDataSetChanged()
        })

    }


    /**
     * 获取banner数据成功
     */
//    fun requestBannerSucces(banners: List<BannerBean.Data>) {
//        //获取banner页面，并赋值,设置监听
//        mBinding.root.swiperecyclerview.adapter = ArticleAdapter(banners)
//        val view = LayoutInflater.from(_mActivity).inflate(R.layout.include_banner, null)
//            .apply { banner.run {
//                setAdapter(BGABanner.Adapter<ImageView,BannerBean.Data> { _, itemView, model, _ ->
//                    Glide.with(_mActivity).load(model?.url).into(itemView)
//                    Log.d("url ", "requestBannerSucces: "+model?.url)
//                })
//                banner.setData(banners, null)
//            }
//        }
////        bgaBanner.setAdapter(BGABanner.Adapter<ImageView, BannerBean.Data> { _: BGABanner, view: ImageView, banner: BannerBean.Data?, i: Int ->
////
////            Glide.with(activity!!).load(banner?.url).into(view)
////
////        })
//        //将banner添加到recycler的头部
//        if (mBinding.root.swiperecyclerview.headerCount == 0) mBinding.root.swiperecyclerview.addHeaderView(view)
//    }


    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
//        mBannerVM.getBanner();
        mArticleListVM.getAriticleList(mPage);
    }


}