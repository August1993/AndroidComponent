package com.example.home.ui.fragment

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseFragment
import com.example.commonlib.base.NoViewModel
import com.example.home.R
import com.example.home.databinding.HomeFragmentLayoutBinding
import com.example.home.ui.adapter.ProjectAdapter
import com.example.home.viewmodel.HomeViewModel
import com.example.mediator.router.HomeRouter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/18 2:51 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = "/home/fragment_home")
class HomeFragment : BaseFragment<HomeFragmentLayoutBinding, HomeViewModel>() {

    val adapter by lazy { ProjectAdapter() }

    override fun getLayoutId(): Int = R.layout.home_fragment_layout

    override fun initView() {
        mViewModel?.getBanner()
        binding.ry.layoutManager = LinearLayoutManager(activity)
        binding.ry.adapter = adapter
        lifecycleScope.launch {
            mViewModel?.getPagingData()?.collect {
                adapter.submitData(it)
            }
        }
        adapter.addLoadStateListener {

        }
    }

}