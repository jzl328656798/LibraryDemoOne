package com.example.applibrary.test

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.applibrary.R
import com.example.applibrary.adapter.*
import com.example.applibrary.adapter.refresh.SwipeRefreshListener
import kotlinx.android.synthetic.main.activity_adapter_test.*

/**
 * CreateTime: 2019-08-03 - 18:46
 * Author: Queen
 * Date: 2019-08-03
 * Time: 18:46
 * Describe: test
 */
class AdapterTestActivity : AppCompatActivity(), RViewCreate<TestAdapterBean>, SwipeRefreshListener {

    private var helper: RViewHelper<TestAdapterBean>? = null

    private var adapter: RViewAdapter<TestAdapterBean>? = null

    private var data: ArrayList<TestAdapterBean> = ArrayList()

    override fun context(): Context {
        return this
    }

    override fun createSwipeRefresh(): SwipeRefreshLayout {
        return swipeRefreshLayout
    }

    override fun createRecyclerView(): RecyclerView {
        return recyclerView
    }

    override fun createRecycleViewAdapter(): RViewAdapter<TestAdapterBean> {
        adapter = RViewAdapter(data, object : RViewItem<TestAdapterBean> {
            override fun getItemLayout(): Int {
                return R.layout.item_list
            }

            override fun openClick(): Boolean {
                return true
            }

            override fun isItemView(entity: TestAdapterBean, position: Int): Boolean {
                return true
            }

            override fun convert(holder: RViewHolder, entity: TestAdapterBean, position: Int) {
                val textView = holder.getView<TextView>(R.id.tv_item)
                textView.text = entity.toString()
            }
        })
        return adapter as RViewAdapter<TestAdapterBean>
    }

    override fun isSupportPaging(): Boolean {
        return false
    }

    override fun onRefresh() {

    }

    private fun notifyAdapterDataSetChanged(data: ArrayList<TestAdapterBean>) {
        helper?.notifyAdapterDataSetChanged(data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_test)
        helper = RViewHelper.build<TestAdapterBean> {
            create = this@AdapterTestActivity
            listener = this@AdapterTestActivity
        }
        initData()
    }

    private fun initData() {
        for (i in 0..29) {
            data.add(TestAdapterBean(i, "name:$i"))
        }
        notifyAdapterDataSetChanged(data)
    }
}