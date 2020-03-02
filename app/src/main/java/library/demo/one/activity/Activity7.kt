package library.demo.one.activity

import android.os.Bundle
import android.view.Gravity
import kotlinx.android.synthetic.main.activity7.*
import library.demo.one.R
import library.demo.one.base.BaseActivity


class Activity7 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity7)

        initView()
    }

    private fun initView() {
        image_view.setOnClickListener { drawer_layout.openDrawer(Gravity.LEFT) }
    }


}