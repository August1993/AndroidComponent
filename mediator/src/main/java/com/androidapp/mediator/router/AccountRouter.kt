package com.androidapp.mediator.router

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/30 10:40 上午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class AccountRouter {
    companion object {
        private const val MODULE_NAME = "/mine"
        const val PAGE_MAIN = "$MODULE_NAME/page_main"
        const val FRAGMENT_PAGE_MAIN = "$MODULE_NAME/fragment_page_main"
        const val SERVICE_INFO = "${MODULE_NAME}/service_userinfo"
    }
}