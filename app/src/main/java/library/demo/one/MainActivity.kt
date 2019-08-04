package library.demo.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applibrary.test.AdapterTestActivity
import kotlinx.android.synthetic.main.activity_main.*
import library.demo.viewlibrary.activity.PhoneVerifyCodeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btn_1.setOnClickListener { startActivity(Intent(this, PhoneVerifyCodeActivity::class.java)) }
        btn_2.setOnClickListener { startActivity(Intent(this, AdapterTestActivity::class.java)) }
    }
}
