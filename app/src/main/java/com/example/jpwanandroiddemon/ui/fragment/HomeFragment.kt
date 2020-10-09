package com.example.jpwanandroiddemon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jpwanandroiddemon.R
import com.example.jpwanandroiddemon.databinding.FragmentHomeBinding
import com.example.jpwanandroiddemon.ui.main.HomeViewModel
import me.yokeyword.fragmentation.SupportFragment

class HomeFragment : SupportFragment() {

    companion object {
        fun newInstance() =
            HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        FragmentHomeBinding.inflate(layoutInflater)
        // TODO: Use the ViewModel
    }

}