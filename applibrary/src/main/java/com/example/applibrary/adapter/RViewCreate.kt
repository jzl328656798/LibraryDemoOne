package com.example.applibrary.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * CreateTime: 2019-08-04 - 10:53
 * Author: Queen
 * Date: 2019-08-04
 * Time: 10:53
 * Describe: init
 */
interface RViewCreate<T> {

    fun context(): Context

    /**
     * 创建下拉刷新
     */
    fun createSwipeRefresh(): SwipeRefreshLayout

    /**
     * 创建RecyclerView
     */
    fun createRecyclerView(): RecyclerView

    /**
     * 创建adapter
     */
    fun createRecycleViewAdapter(): RViewAdapter<T>

    /**
     * 是否支持分页
     */
    fun isSupportPaging(): Boolean

}