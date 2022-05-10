package com.androidapp.module.mine.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.androidapp.mediator.router.MineRouter
import com.example.mine.R
import com.example.mine.databinding.MineActivityMineBinding

@Route(path = MineRouter.PAGE_MAIN)
class MineActivity : BaseActivity<MineActivityMineBinding, NoViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.mine_activity_mine
    }

    override fun initView() {

    }

}