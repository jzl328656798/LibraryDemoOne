package library.demo.one.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test2.*
import library.demo.one.data.Test2DateViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import library.demo.one.adapter.Test2Adapter


/**
 * CreateTime: 2019-08-22 - 16:16
 * Author: Queen
 * Date: 2019-08-22
 * Time: 16:16
 * Describe: test1
 */
class Test2Activity : AppCompatActivity() {

    private var model: Test2DateViewModel? = null
    private var adapter: Test2Adapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = ViewModelProviders.of(this).get(Test2DateViewModel::class.java)


        model?.getCurrentName()?.observe(this, Observer<String> { tv_title.text = it })
        model?.getNameList()?.observe(this, Observer<ArrayList<String>> { adapter?.setData(it) })

        setContentView(library.demo.one.R.layout.activity_test2)


        initView()

    }

    private fun initView() {

        btn_edit_title.setOnClickListener { editTitle() }
        btn_add_item.setOnClickListener { addItem() }
        btn_subtraction_item.setOnClickListener { subtractionItem() }

        rv_test2.layoutManager = LinearLayoutManager(this)
        adapter = Test2Adapter(model?.getNameList()?.value)
        rv_test2.adapter = adapter
    }


    private fun editTitle() {
        model?.getCurrentName()?.value = "123"
    }

    private fun addItem() {
        var list = model?.getNameList()?.value
        if (list == null) {
            list = ArrayList()
            model?.getNameList()?.value = list
        }
        list.add("111")
        model?.getNameList()?.value = list

    }

    private fun subtractionItem() {
        var list = model?.getNameList()?.value
        if (list == null) {
            list = ArrayList()
            model?.getNameList()?.value = list
        }
        if (list.size > 0) {
            list.removeAt(0)
            model?.getNameList()?.value = list
        }
    }
}