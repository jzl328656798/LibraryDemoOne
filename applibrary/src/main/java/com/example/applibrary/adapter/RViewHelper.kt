package com.example.applibrary.adapter

import android.content.Context
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.applibrary.adapter.refresh.SwipeRefreshHelper
import com.example.applibrary.adapter.refresh.SwipeRefreshListener
import kotlinx.android.synthetic.main.activity_adapter_test.view.*

/**
 * Created by queen on 2019-08-03.
 * CreateTime: 2019-08-03 - 17:59
 * Author: Queen
 * Date: 2019-08-03
 * Time: 17:59
 * Describe: help
 */
class RViewHelper<T> private constructor(
    var context: Context,
    var swipeRefreshLayout: SwipeRefreshLayout,
    var swipeRefreshHelper: SwipeRefreshHelper,
    var recyclerView: RecyclerView,
    var adapter: RViewAdapter<T>,
    var startPageNumber: Int = 1,
    var isSupportPaging: Boolean = false,
    var swipeRefreshListener: SwipeRefreshListener,
    var currentPageNum: Int = 1
) {


    private constructor(builder: Builder<T>) : this(
        builder.create.context(),
        builder.create.createSwipeRefresh(),
        SwipeRefreshHelper.createSwipeRefreshHelper(builder.create.createSwipeRefresh()),
        builder.create.createRecyclerView(),
        builder.create.createRecycleViewAdapter(),
        1,
        false,
        builder.listener,
        1
    ) {
        initView()
    }

    companion object {
        fun <T> build(init: Builder<T>.() -> Unit) = Builder<T>(init).build()
    }


    fun notifyAdapterDataSetChanged(data: ArrayList<T>) {
        if (currentPageNum == startPageNumber) {
            adapter.update(data)
        } else {
            adapter.addData(data)
        }
        recyclerView.adapter = adapter

    }

    private fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        swipeRefreshHelper.setSwipeRefreshListener(object : SwipeRefreshListener {
            override fun onRefresh() {
                dismissSwipeRefresh()
                currentPageNum = startPageNumber
                swipeRefreshListener.onRefresh()
            }
        })
    }

    private fun dismissSwipeRefresh() {
        if (swipeRefreshLayout.isRefreshing) swipeRefreshLayout.isRefreshing = false
    }

    class Builder<T> private constructor() {
        constructor(init: Builder<T>.() -> Unit) : this() {
            init()
        }

        lateinit var create: RViewCreate<T>
        lateinit var listener: SwipeRefreshListener

        fun create(init: Builder<T>.() -> RViewCreate<T>) = apply { create = init() }
        fun listener(init: Builder<T>.() -> SwipeRefreshListener) = apply { listener = init() }

        fun build() = RViewHelper<T>(this)
    }
}