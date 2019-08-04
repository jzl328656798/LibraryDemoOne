package com.example.applibrary.adapter.refresh

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * CreateTime: 2019-08-04 - 10:39
 * Author: Queen
 * Date: 2019-08-04
 * Time: 10:39
 * Describe: refresh
 */
class SwipeRefreshHelper {

    private val swipeRefresh: SwipeRefreshLayout
    private var swipeRefreshListener: SwipeRefreshListener? = null

    private constructor(swipeRefresh: SwipeRefreshLayout) {
        this.swipeRefresh = swipeRefresh
        initView()
    }

    private fun initView() {
        swipeRefresh.setColorSchemeResources(
            android.R.color.holo_orange_dark,
            android.R.color.holo_green_dark,
            android.R.color.holo_blue_dark
        )
        swipeRefresh.setOnRefreshListener { swipeRefreshListener?.onRefresh() }
    }

    fun setSwipeRefreshListener(swipeRefreshListener: SwipeRefreshListener) {
        this.swipeRefreshListener = swipeRefreshListener
    }

    companion object {
        fun createSwipeRefreshHelper(swipeRefresh: SwipeRefreshLayout): SwipeRefreshHelper {
            return SwipeRefreshHelper(swipeRefresh)
        }
    }
}