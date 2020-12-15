package com.example.jpwanandroiddemon

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.jpwanandroiddemon.databinding.MainActivityBinding
import com.example.jpwanandroiddemon.ui.JetApp
import com.example.jpwanandroiddemon.ui.fragment.MainFragment
import com.example.jpwanandroiddemon.utils.StatusBarUtil
import com.example.jpwanandroiddemon.vm.AppViewModel
import me.yokeyword.fragmentation.SupportActivity

class MainActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = MainActivityBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        initStatusBar()
        initFragment()
    }

    private fun initStatusBar() {

        val appViewModel = (application as JetApp).getAppProvider().get(AppViewModel::class.java)
        appViewModel.appStatusColor.observe(this, Observer {
            StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary),0)
        })
    }

    private fun initFragment() {
        if (findFragment(MainFragment::class.java) == null) {
//            val beginTransaction = supportFragmentManager.beginTransaction()
//            val newInstance = MainFragment.newInstance()
//            beginTransaction.add(R.id.fl,newInstance)
//            beginTransaction.show(newInstance)
//            Log.d("lzz","newInstance:"+newInstance+",MainFragment.newInstance()："+MainFragment.newInstance())
//            beginTransaction.commitNow()

            loadRootFragment(R.id.fl, MainFragment.newInstance())
        }
    }

}