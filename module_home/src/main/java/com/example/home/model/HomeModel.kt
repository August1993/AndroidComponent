package com.example.home.model

import com.example.commonlib.base.BaseModel
import com.example.commonlib.http.model.NetResult
import com.example.home.model.bean.Banner
import com.example.home.model.bean.ProjectBean
import com.example.home.model.service.RequestCenter

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/30 4:50 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class HomeModel : BaseModel() {
    suspend fun getBanner(): NetResult<List<Banner>> {
        return callRequest(call = { requestBanner() })
    }

    suspend fun getProjectList(pageNum: Int): NetResult<ProjectBean> {
        return callRequest(call = { requestProjectList(pageNum) })
    }

    private suspend fun requestBanner() =
        handleResponse(buildService(RequestCenter::class.java).getBanner())

    private suspend fun requestProjectList(pageNum: Int) =
        handleResponse(buildService(RequestCenter::class.java).getProjectList(pageNum))
}