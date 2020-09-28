package com.example.jpwanandroiddemon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jpwanandroiddemon.databinding.ProjectFragmentBinding
import me.yokeyword.fragmentation.SupportFragment

class ProjectFragment : SupportFragment() {

    companion object {
        fun newInstance() = ProjectFragment()
    }

    private lateinit var viewModel: ProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  ProjectFragmentBinding.inflate(layoutInflater).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}