package com.example.commonlib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.reflect.ParameterizedType

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/12 4:25 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
abstract class BaseDialog<V : ViewDataBinding, VM : BaseViewModel<*>> : DialogFragment() {

    var viewContent: View? = null

    var binding: V? = null

    var viewModel: VM? = null

    abstract fun getLayoutId(): Int

    abstract fun setupWindow(window: Window)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewContent = inflater.inflate(getLayoutId(), container, false)
        return viewContent

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
        initView()
        initListener()
        initData()
    }

    fun initDataBinding() {
        binding = DataBindingUtil.bind(viewContent!!)!!
        viewModel = initCustomViewModel()
        if (viewModel == null) {
            val type = javaClass.genericSuperclass
            if (type is ParameterizedType) {
                var modelClass: Class<VM>? = null
                modelClass = type.actualTypeArguments[1] as Class<VM>
                viewModel = createViewModel(this, modelClass)
            } else {
                var modelClass = NoViewModel::class.java
                viewModel = createViewModel(this, modelClass) as VM
            }
        }
        lifecycle.addObserver(viewModel!!)

    }

    open fun initView() {

    }

    open fun initListener() {

    }

    open fun initData() {

    }

   open fun initCustomViewModel(): VM? {
        return null
    }

    override fun onStart() {
        super.onStart()
        dialog?.run {
            window?.let { setupWindow(it) }
        }
    }

    private fun <T : ViewModel> createViewModel(
        fragment: DialogFragment,
        clazz: Class<T>
    ): T {
        return ViewModelProvider(fragment)[clazz]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycle.removeObserver(viewModel!!)
        if (binding != null) {
            binding!!.unbind()
        }

    }
}