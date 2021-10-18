package com.example.androidcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/18 4:06 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class TestFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.test_fragment_layout,container,false)

    }

}