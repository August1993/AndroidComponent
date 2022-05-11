package com.example.commonlib.base

import android.os.Bundle
import android.view.View
import android.view.ViewStub
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonlib.R
import com.example.commonlib.http.model.ResultException
import com.rxjava.rxlife.RxConverter
import com.rxjava.rxlife.RxLife
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity
import com.wuhenzhizao.titlebar.widget.CommonTitleBar
import java.lang.reflect.ParameterizedType

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/7 4:01 下午
 *     version: 1.0
 *     desc   :BaseActivity
 * </pre>
 */
abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel<*>> : RxAppCompatActivity() {

    lateinit var binding: V

    var mViewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_layout)
        initContentView()
        ARouter.getInstance().inject(this)
        initViewModel()
        registerUiChangeObservable()
        initListener()
        initView()
    }

    abstract fun getLayoutId(): Int

    open fun enableSimpleTitle(): Boolean = false

    abstract fun initView()

    open fun initListener() {

    }

    open fun bindCenterTitle(): String {
        return ""
    }

    /** init left start */
    open fun bindLeftType(): Int {
        return CommonTitleBar.TYPE_LEFT_TEXTVIEW
    }

    open fun bindLeftText(): String {
        return ""
    }

    open fun bindLeftIcon(): Int {
        return 0
    }

    open fun bindLeftClickListener(): View.OnClickListener {
        return null!!
    }
    /** init left end */

    /** init left start */
    open fun bindRightType(): Int {
        return CommonTitleBar.TYPE_RIGHT_TEXTVIEW
    }

    open fun bindRightText(): String {
        return ""
    }

    open fun bindRightIcon(): Int {
        return 0
    }

    open fun bindRightClickListener(): View.OnClickListener {
        return null!!
    }

    /** init right end  */
    private fun initContentView() {
        if (enableSimpleTitle()) {
            val viewStub = findViewById<ViewStub>(R.id.simple_title)
            val inflate = viewStub.inflate()
            val commonTitleBar = inflate.findViewById<CommonTitleBar>(R.id.common_title_bar)
            commonTitleBar.centerTextView.text = bindCenterTitle()
            commonTitleBar.setLeftType(bindLeftType())
            commonTitleBar.setRightType(bindRightType())
            when (bindLeftType()) {
                CommonTitleBar.TYPE_LEFT_TEXTVIEW -> {
                    commonTitleBar.leftTextView.text = bindLeftText()
                }
                CommonTitleBar.TYPE_LEFT_IMAGEBUTTON -> {
                    commonTitleBar.leftImageButton.setImageResource(bindLeftIcon())
                }
            }
            when (bindRightType()) {
                CommonTitleBar.TYPE_RIGHT_TEXTVIEW -> {
                    commonTitleBar.rightTextView.text = bindRightText()
                }
                CommonTitleBar.TYPE_LEFT_IMAGEBUTTON -> {
                    commonTitleBar.rightImageButton.setImageResource(bindRightIcon())
                }
            }

            commonTitleBar.setListener { v, action, _ ->
                when (action) {
                    CommonTitleBar.ACTION_LEFT_TEXT, CommonTitleBar.ACTION_LEFT_BUTTON -> {
                        bindLeftClickListener().apply {
                            onClick(v)
                        }
                    }
                    CommonTitleBar.ACTION_RIGHT_TEXT, CommonTitleBar.ACTION_RIGHT_BUTTON -> {
                        bindRightClickListener().apply {
                            onClick(v)
                        }
                    }
                    else -> {
                    }
                }
            }
        }
        val contentViewStub = findViewById<ViewStub>(R.id.content_layout)
        contentViewStub.layoutResource = getLayoutId()
        val inflate = contentViewStub.inflate()
        binding = DataBindingUtil.bind(inflate)!!
    }

    private fun initViewModel() {
        mViewModel = initCustomViewModel()
        if (mViewModel == null) {
            val type = javaClass.genericSuperclass
            if (type is ParameterizedType) {
                var modelClass: Class<VM>? = null
                modelClass = type.actualTypeArguments[1] as Class<VM>
                mViewModel = createViewModel(this, modelClass)
            } else {
                var modelClass = NoViewModel::class.java
                mViewModel = createViewModel(this, modelClass) as VM
            }
        }
        lifecycle.addObserver(mViewModel!!)
    }

    private fun registerUiChangeObservable() {
        mViewModel?.uiChangeLiveData?.showLoadingEvent?.observe(this, {
            showLoadingView(it!!)
        })

        mViewModel?.uiChangeLiveData?.showErrorEvent?.observe(this, {
            showErrorView(it?.exception)
        })

    }

    open fun showLoadingView(loading: Boolean) {
        val loadingView: View? = findViewById(R.id.loading_layout)
        if (loadingView != null) {
            loadingView.visibility = if (loading) View.VISIBLE else View.GONE
        }
        val errorView: View? = findViewById(R.id.error_layout)
        if (errorView != null) {
            errorView.visibility = View.GONE
        }
    }

    /**
     * 展示错误页面
     *
     * @param throwable 异常
     */
    protected open fun showErrorView(throwable: Throwable?) {
        val loadingView: View? = findViewById<View>(R.id.loading_layout)
        if (loadingView != null) {
            loadingView.visibility = View.GONE
        }
        val errorView: View? = findViewById(R.id.error_layout)
        if (errorView != null) {
            errorView.visibility = View.VISIBLE
            val errorIv: ImageView = findViewById(R.id.iv_error)

        }
        val errorTv: TextView = findViewById<TextView>(R.id.tv_error)
        if (throwable?.message!!.isNotEmpty()) {

            if (throwable is ResultException) {
                errorTv.text = throwable.message
            } else {
                errorTv.text = throwable.message
            }
        }
        val operationTv: TextView? = findViewById(R.id.tv_operation)
        if (operationTv != null) {


        }
    }

    private fun <T : ViewModel> createViewModel(
        fragmentActivity: FragmentActivity,
        clazz: Class<T>
    ): T {
        return ViewModelProvider(fragmentActivity)[clazz]
    }

    fun initCustomViewModel(): VM? = null

    fun <T> bindLifecycle(): RxConverter<T> {
        return RxLife.`as`(this)
    }


}