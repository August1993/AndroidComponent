package com.androidapp.module.main.ui.fragment


import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.androidapp.mediator.router.AccountRouter
import com.androidapp.mediator.router.MainRouter
import com.example.commonlib.base.BaseFragment
import com.example.commonlib.base.NoViewModel
import com.androidapp.mediator.service.IUserInfoService
import com.example.module.R
import com.example.module.databinding.MainFragmentLayoutBinding
import com.zhpan.idea.utils.ToastUtils

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/18 2:51 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = MainRouter.FRAGMENT_PAGE_MAIN)
class MainFragment:BaseFragment<MainFragmentLayoutBinding,NoViewModel>() {

//    @Autowired
    lateinit  var userService: IUserInfoService

    override fun getLayoutId(): Int = R.layout.main_fragment_layout

    override fun initView() {
        binding.tv.setOnClickListener {
//            ARouter.getInstance().build(HomeRouter.PAGE_MAIN).navigation()
//            val build = ARouter.getInstance().build(AccountRouter.SERVICE_INFO) as IUserInfoService
            ToastUtils.show(userService.userName)
        }
    }
}