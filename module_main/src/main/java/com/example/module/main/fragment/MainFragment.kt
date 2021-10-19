package com.example.module.main.fragment


import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonlib.base.BaseFragment
import com.example.commonlib.base.NoViewModel
import com.example.mediator.router.HomeRouter
import com.example.module.R
import com.example.module.databinding.MainFragmentLayoutBinding

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/18 2:51 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = "/main/fragment_main")
class MainFragment:BaseFragment<MainFragmentLayoutBinding,NoViewModel>() {
    override fun getLayoutId(): Int = R.layout.main_fragment_layout

    override fun initView() {
        binding.tv.setOnClickListener {
            ARouter.getInstance().build(HomeRouter.PAGE_MAIN).navigation()
        }
    }
}