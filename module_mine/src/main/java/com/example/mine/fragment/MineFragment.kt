package com.example.mine.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseFragment
import com.example.commonlib.base.NoViewModel
import com.example.mine.R
import com.example.mine.databinding.MineFragmentLayoutBinding

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/18 2:51 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = "/mine/fragment_mine")
class MineFragment:BaseFragment<MineFragmentLayoutBinding,NoViewModel>() {
    override fun getLayoutId(): Int = R.layout.mine_fragment_layout

    override fun initView() {

    }
}