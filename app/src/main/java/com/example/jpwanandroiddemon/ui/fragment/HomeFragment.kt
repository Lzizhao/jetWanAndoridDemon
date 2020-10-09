package com.example.jpwanandroiddemon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jpwanandroiddemon.R
import com.example.jpwanandroiddemon.databinding.FragmentHomeBinding
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.EmptyCallback
import com.example.jpwanandroiddemon.ui.custom.loadCallBack.LoadingCallback
import com.example.jpwanandroiddemon.ui.main.HomeViewModel
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import me.yokeyword.fragmentation.SupportFragment

class HomeFragment : SupportFragment() {

    companion object {
        fun newInstance() =
            HomeFragment()
    }

    private lateinit var mViewModel: HomeViewModel
    private lateinit var mLoadSir: LoadService<Any>
    private lateinit var mBinding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(true)//加上这句话，menu才会显示出来
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =  FragmentHomeBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        FragmentHomeBinding.inflate(layoutInflater)
        // TODO: Use the ViewModel
        initData();
    }

    private fun initData() {
        mLoadSir = LoadSir.getDefault().register(mBinding.root.findViewById(R.id.swipeRefreshLayout), Callback.OnReloadListener {
            mLoadSir.showCallback(LoadingCallback::class.java)
        })
        mLoadSir.showCallback(EmptyCallback::class.java)
    }


    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)

    }



}