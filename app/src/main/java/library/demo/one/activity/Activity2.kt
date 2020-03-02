package library.demo.one.activity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity2.*
import library.demo.one.base.BaseActivity

class Activity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(library.demo.one.R.layout.activity2)
        initView()
    }

    private fun initView() {
        btn_top.setOnClickListener {
            it.post { sl_activity2.smoothScrollBy(0, 0) }
            it.post { kotlin.run { sl_activity2.smoothScrollBy(0, 0) } }
        }
        btn_bottom.setOnClickListener { sl_activity2.fullScroll(View.FOCUS_UP) }


        addLinearLayoutView()
    }


    private fun addLinearLayoutView() {

        for (i in 0..80) {
            val view = TextView(this)
            view.width = 100
            view.height = 100
            view.gravity = Gravity.CENTER
            view.text = "item:$i"
            ll_activity2.addView(view)
        }

    }

}