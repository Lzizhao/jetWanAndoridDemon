package com.example.jpwanandroiddemon.ui.fragment

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jpwanandroiddemon.R
import com.example.jpwanandroiddemon.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*
import me.yokeyword.fragmentation.SupportFragment

class MainFragment : SupportFragment() {
    companion object {
        fun newInstance() =
            MainFragment()
    }

//    private lateinit var viewModel: MainViewModel

    private val first = 0
    private val two = 1
    private val three = 2
    private val four = 3
    private val five = 4
    private val mFragments = arrayOfNulls<SupportFragment>(5)
    private lateinit var mainFragmentBinding: MainFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mainFragmentBinding  = MainFragmentBinding.inflate(layoutInflater)
        return mainFragmentBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        initFragments();
    }

    @SuppressLint("ResourceAsColor")
    private fun initFragments() {

        val homeFragment = findChildFragment(HomeFragment::class.java)
        if (homeFragment == null) {
            mFragments[first] =
                HomeFragment.newInstance()//主页
            mFragments[two] = ProjectFragment.newInstance()//项目
            mFragments[three] = ProjectFragment.newInstance()//体系
            mFragments[four] = ProjectFragment.newInstance()//公众号
            mFragments[five] = ProjectFragment.newInstance()//我的
            loadMultipleRootFragment(R.id.fl, first, mFragments[first]
                , mFragments[two], mFragments[three], mFragments[four], mFragments[five])
        } else {
            mFragments[first] = homeFragment
            mFragments[two] = findChildFragment(ProjectFragment::class.java)
            mFragments[three] = findChildFragment(ProjectFragment::class.java)
            mFragments[four] = findChildFragment(ProjectFragment::class.java)
            mFragments[five] = findChildFragment(ProjectFragment::class.java)
        }

        bnv?.run {
            enableAnimation(false)
            itemIconTintList = ColorStateList.valueOf(R.color.colorPrimaryDark)
            itemTextColor =  ColorStateList.valueOf(R.color.colorPrimaryDark)
            setIconSize(20F, 20F)
            setTextSize(12F)
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main -> showHideFragment(mFragments[first])
                    R.id.menu_project -> showHideFragment(mFragments[two])
                    R.id.menu_system -> showHideFragment(mFragments[three])
                    R.id.menu_public -> showHideFragment(mFragments[four])
                    R.id.menu_me -> showHideFragment(mFragments[five])
                }
                true
            }
        }

    }

}