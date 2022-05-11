package com.androidapp.module.home.ui.fragment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.androidapp.module.home.model.bean.Banner
import com.example.commonlib.base.BaseFragment
import com.example.home.R
import com.example.home.databinding.HomeFragmentLayoutBinding
import com.androidapp.module.home.ui.adapter.ProjectAdapter
import com.androidapp.module.home.viewmodel.HomeViewModel
import com.example.commonlib.event.RxBus
import com.wuhenzhizao.titlebar.widget.CommonTitleBar
import com.zhpan.idea.utils.ToastUtils
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
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

    override fun enableSimpleTitle(): Boolean = true

    override fun bindCenterTitle(): String = "superTitle"

    override fun bindLeftType(): Int = CommonTitleBar.TYPE_LEFT_TEXTVIEW

    override fun bindLeftText(): String = "取消"

    override fun bindLeftIcon(): Int = R.drawable.comm_titlebar_search_normal

    override fun bindRightType(): Int = CommonTitleBar.TYPE_RIGHT_TEXTVIEW

    override fun bindRightIcon(): Int = R.drawable.comm_titlebar_voice

    override fun bindRightText(): String = "确定"

    override fun getLayoutId(): Int = R.layout.home_fragment_layout

    override fun bindLeftClickListener(): View.OnClickListener {
        return View.OnClickListener { Toast.makeText(activity, "left", Toast.LENGTH_SHORT).show() }
    }

    override fun initView() {
        binding.tv.setOnClickListener {
            mViewModel!!.getBanner()
        }

    }

    override fun initListener() {
        super.initListener()
        mViewModel?.bannerLiveData?.observe(this,
            object : androidx.lifecycle.Observer<List<Banner>> {
                override fun onChanged(t: List<Banner>?) {
                    binding.tv.text = t.toString()
                }

            })
        RxBus.instance
            ?.toObservable(123, String::class.java)
            ?.subscribe {
                ToastUtils.show("123消息接收成功 $it")
            }

        RxBus.instance
            ?.toObservable(456, String::class.java)
            ?.subscribe({
                ToastUtils.show("456消息接收成功 $it")
            })

    }

}