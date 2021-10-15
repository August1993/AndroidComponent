package com.example.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.example.mediator.router.MineRouter
import com.example.mine.databinding.ActivityMainBinding
import com.example.mine.databinding.MineActivityMineBinding

@Route(path = MineRouter.PAGE_MAIN)
class MineActivity : BaseActivity<MineActivityMineBinding, NoViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.mine_activity_mine
    }

    override fun initView() {

    }

}