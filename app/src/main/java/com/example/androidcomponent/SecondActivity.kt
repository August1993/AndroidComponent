package com.example.androidcomponent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/7 2:21 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = "/second/page")
class SecondActivity : AppCompatActivity() {
    @JvmField
    @Autowired
    var key3: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_second)

    }

}