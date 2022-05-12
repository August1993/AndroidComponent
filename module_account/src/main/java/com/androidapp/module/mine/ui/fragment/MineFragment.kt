package com.androidapp.module.mine.ui.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.androidapp.mediator.router.AccountRouter
import com.androidapp.mediator.service.IUserInfoService
import com.example.commonlib.base.BaseFragment
import com.example.commonlib.base.NoViewModel
import com.example.commonlib.util.LogUtils
import com.example.mine.R
import com.example.mine.databinding.MineFragmentLayoutBinding
import kotlin.random.Random

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/18 2:51 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = AccountRouter.FRAGMENT_PAGE_MAIN)
class MineFragment : BaseFragment<MineFragmentLayoutBinding, NoViewModel>() {
    val url = "https://s.kjcdn.com/app/android/huashengxiaoshuo1.1.17.apk"
    override fun getLayoutId(): Int = R.layout.mine_fragment_layout

    override fun initView() {
//        <!--    <root-path/> 代表设备的根目录new File("/");-->
//        <!--    <files-path/> 代表context.getFilesDir()-->
//        <!--    <cache-path/> 代表context.getCacheDir()-->
//        <!--    <external-path/> 代表Environment.getExternalStorageDirectory()-->
//        <!--    <external-files-path>代表context.getExternalFilesDirs()-->
//        <!--    <external-cache-path>代表getExternalCacheDirs()-->
        val filesDir = activity!!.filesDir
        val cacheDir = activity!!.cacheDir
        val externalStorageState = activity!!.getExternalFilesDir(null)
        val externalFilesDir = activity!!.getExternalFilesDir("/")
        val externalCacheDirs = activity!!.externalCacheDirs
        LogUtils.d("path", "filesDir  $filesDir")
        LogUtils.d("path", "cacheDir  $cacheDir")
        LogUtils.d("path", "externalStorageState  $externalStorageState")
        LogUtils.d("path", "externalFilesDir  $externalFilesDir")
        LogUtils.d("path", "externalCacheDirs  $externalCacheDirs")
        LogUtils.d("downloadFile", "before")


        binding.download.setOnClickListener {
            val build = ARouter.getInstance().build(AccountRouter.SERVICE_INFO).navigation() as IUserInfoService
            val nextInt = Random.nextInt(100)
            build.userName="testUser_name $nextInt"

        }


    }
}