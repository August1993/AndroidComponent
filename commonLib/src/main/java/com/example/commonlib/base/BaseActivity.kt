package com.example.commonlib.base

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonlib.R
import com.wuhenzhizao.titlebar.widget.CommonTitleBar

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/7 4:01 下午
 *     version: 1.0
 *     desc   :BaseActivity
 * </pre>
 */
abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {
//
    var binding: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_layout)
        initContentView()
        ARouter.getInstance().inject(this)
    }

    abstract fun getLayoutId(): Int

    abstract fun enableSimpleTitle(): Boolean

    abstract fun initView()

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
        val content_view_stub = findViewById<ViewStub>(R.id.content_layout)
        content_view_stub.layoutResource = getLayoutId()
        val inflate = content_view_stub.inflate()
        binding = DataBindingUtil.bind(inflate)
    }

}