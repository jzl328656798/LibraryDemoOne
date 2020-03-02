package library.demo.one

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import library.demo.one.activity.*
import library.demo.one.receiver.InstallUninstallBroadcastReceiver

class MainActivity : AppCompatActivity() {

    private var test1: InstallUninstallBroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btn_1.setOnClickListener { startActivity(Intent(this, Activity1::class.java)) }
        btn_2.setOnClickListener { startActivity(Intent(this, Activity2::class.java)) }
        btn_3.setOnClickListener { startActivity(Intent(this, Activity3::class.java)) }
        btn_4.setOnClickListener { startActivity(Intent(this, Activity4::class.java)) }
        btn_5.setOnClickListener { startActivity(Intent(this, Activity5::class.java)) }
        btn_6.setOnClickListener { startActivity(Intent(this, Activity6::class.java)) }
        btn_7.setOnClickListener { startActivity(Intent(this, Activity7::class.java)) }
        btn_8.setOnClickListener { startActivity(Intent(this, Activity8::class.java)) }
        btn_9.setOnClickListener { startActivity(Intent(this, Activity9::class.java)) }
        btn_10.setOnClickListener { startActivity(Intent(this, Activity7::class.java)) }
        btn_11.setOnClickListener { startActivity(Intent(this, Activity7::class.java)) }
        btn_12.setOnClickListener { startActivity(Intent(this, Activity7::class.java)) }

        test1 = InstallUninstallBroadcastReceiver()
        registerInstallAppBroadcastReceiver()

    }


    private fun registerInstallAppBroadcastReceiver() {

        val intentFilter = IntentFilter()

        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED)

        intentFilter.addAction(Intent.ACTION_PACKAGE_REPLACED)

        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED)

        intentFilter.addDataScheme("package")

        registerReceiver(test1, intentFilter)

    }


    override fun onDestroy() {
        super.onDestroy()
        if (test1 != null) {
            unregisterReceiver(test1)
        }
    }


}
