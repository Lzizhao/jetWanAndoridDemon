package com.example.jpwanandroiddemon

import android.os.Bundle
import com.example.jpwanandroiddemon.ui.fragment.MainFragment
import me.yokeyword.fragmentation.SupportActivity

class MainActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity) //LZZ issues 不能用databing 找不到R.id.rl
        initFragment();
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