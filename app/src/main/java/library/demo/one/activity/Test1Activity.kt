package library.demo.one.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_test1.*
import library.demo.one.R
import library.demo.one.adapter.Test1Adapter

/**
 * CreateTime: 2019-08-22 - 16:16
 * Author: Queen
 * Date: 2019-08-22
 * Time: 16:16
 * Describe: test1
 */
class Test1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)


        initView()
    }

    private fun initView() {
        rv_test1.layoutManager = GridLayoutManager(this, 3, RecyclerView.VERTICAL, false)
        rv_test1.adapter = Test1Adapter(getData())
    }

    private fun getData(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("1")
        list.add("1")
        list.add("1")
        list.add("1")
        list.add("1")
        list.add("1")
        list.add("1")
        return list
    }
}