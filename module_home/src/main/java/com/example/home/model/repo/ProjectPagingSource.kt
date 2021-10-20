package com.example.home.model.repo

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apkfuns.logutils.LogUtils
import com.example.home.model.bean.Data
import com.example.home.model.service.RequestCenter

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/9 2:23 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class ProjectPagingSource(private val requestCenter: RequestCenter) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val projectList = requestCenter.getProjectList(page)
            val projectItems = projectList.data.datas
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (projectItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(projectItems, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? = null

}