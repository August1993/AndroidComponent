package com.example.commonlib.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.commonlib.R
import com.example.commonlib.base.BaseDialog
import com.example.commonlib.base.NoViewModel
import com.example.commonlib.databinding.DialogMessageBinding
import com.wuhenzhizao.titlebar.utils.ScreenUtils
import java.io.Serializable

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/11 4:09 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class CommonMessageDialog : BaseDialog<DialogMessageBinding, NoViewModel>() {

    override fun setupWindow(win: Window) {
        val win = dialog!!.window
        win!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dm = DisplayMetrics()
        dialog!!.setCanceledOnTouchOutside(false)
        activity!!.windowManager.defaultDisplay.getMetrics(dm)
        val params = win!!.attributes
        val width: Int = ScreenUtils.getScreenWidth(activity) - ScreenUtils.dp2Px(activity, 45) * 2
        params.width = width
        params.gravity = Gravity.CENTER
        win!!.attributes = params
    }

    override fun initView() {
        super.initView()
        val bundle = arguments
        var builderData: MessageDialogBuilderData? = null
        if (bundle != null) {
            builderData = bundle.getSerializable("data") as MessageDialogBuilderData
        }
        builderData?.run {
            binding?.tvDialogMessageTitle?.text = titleText
            binding?.tvDialogMessageTitle?.setTextColor(titleTextColor)

            binding?.tvDialogMessageMessage?.text = messageText
            binding?.tvDialogMessageMessage?.setTextColor(messageTextColor)

            binding?.tvNegative?.text = negativeText
            binding?.tvNegative?.setTextColor(negativeTextColor)

            binding?.tvPositive?.text = positiveText
            binding?.tvPositive?.setTextColor(positiveTextColor)

            binding?.tvNegative?.setOnClickListener(negativeClickListener)
            binding?.tvPositive?.setOnClickListener(positiveClickListener)


            isCancelable = isCancel

        }


    }

    override fun getLayoutId(): Int = R.layout.dialog_message

    class Builder() {
        var builderData = MessageDialogBuilderData()
        fun setTitleText(title: String): Builder {
            builderData.titleText = title
            return this
        }

        fun setMessageText(messageText: String): Builder {
            builderData.messageText = messageText
            return this
        }

        fun setNegativeText(text: String): Builder {
            builderData.negativeText = text
            return this
        }

        fun setPositiveText(text: String): Builder {
            builderData.positiveText = text
            return this
        }

        fun setTitleColor(color: Int): Builder {
            builderData.titleTextColor = color
            return this
        }

        fun setMessageColor(color: Int): Builder {
            builderData.messageTextColor = color
            return this
        }

        fun setNegativeTextColor(color: Int): Builder {
            builderData.negativeTextColor = color
            return this
        }

        fun setPositiveTextColor(color: Int): Builder {
            builderData.positiveTextColor = color
            return this
        }

        fun setRadius(radius: Int): Builder {
            builderData.radius = radius
            return this
        }

        fun setCancelable(isCancel: Boolean): Builder {
            builderData.isCancel = isCancel
            return this
        }

        fun setPositiveClickListener(onClickListener: View.OnClickListener): Builder {
            builderData.positiveClickListener = onClickListener
            return this
        }

        fun setNegativeClickListener(onClickListener: View.OnClickListener): Builder {
            builderData.negativeClickListener = onClickListener
            return this
        }

        fun show(fm: FragmentManager, tag: String) {
            var dialog = CommonMessageDialog().apply {
                var bundle = Bundle().apply {
                    putSerializable("data", builderData)
                }
                arguments = bundle
                show(fm, tag)
            }
        }
    }
}

class MessageDialogBuilderData : Serializable {

    /**text*/
    var titleText: String = ""
    var messageText: String = ""
    var negativeText: String = ""
    var positiveText: String = ""

    /**color*/
    var titleTextColor: Int = Color.BLACK
    var messageTextColor: Int = Color.BLACK
    var negativeTextColor: Int = Color.BLACK
    var positiveTextColor: Int = Color.BLACK

    /**style*/
    var radius: Int = 0
    var isCancel: Boolean = false

    /**listener*/
    var positiveClickListener: View.OnClickListener? = null
    var negativeClickListener: View.OnClickListener? = null
}



