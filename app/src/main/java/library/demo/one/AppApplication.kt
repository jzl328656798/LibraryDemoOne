package library.demo.one

import android.app.Application
import android.util.Log
import com.example.applibrary.manager.AppManager
import com.example.applibrary.net.NetworkListener
import com.example.applibrary.net.NetworkManager
import com.example.applibrary.net.NetworkType
import com.example.applibrary.utils.AppActivityLifecycleCallbacks
import library.demo.one.base.BaseActivity
import org.apache.weex.InitConfig
import org.apache.weex.WXSDKEngine
import org.apache.weex.adapter.DefaultWXHttpAdapter


/**
 * Author: Queen
 * Date: 2019-11-12 16:46
 * ----------Dragon be here!----------/
 * 　　　┏┓　　 ┏┓
 * 　　┏┛┻━━━┛┻┓━━━
 * 　　┃　　　　　 ┃
 * 　　┃　　　━　  ┃
 * 　　┃　┳┛　┗┳
 * 　　┃　　　　　 ┃
 * 　　┃　　　┻　  ┃
 * 　　┃　　　　   ┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛━━━━━
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━━━━━━神兽出没━━━━━━━━━━━━━━
 *
 * Describe: Application
 */
class AppApplication : Application(), NetworkListener {

    override fun connectState(state: Boolean) {
        val topActivity = AppManager.getTopActivity()
        topActivity?.run {
            if (topActivity is BaseActivity) {
                topActivity.showNetworkConnectState(state)
            }
        }
    }

    override fun connectType(type: NetworkType) {

    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(AppActivityLifecycleCallbacks())
        initOther()
        initWex()
    }

    private fun initOther() {
        NetworkManager.initNetworkListener(this, this)
    }

    private fun initWex() {
        try {

            val config = InitConfig.Builder()
                //图片库接口
//            .setImgAdapter(FrescoImageAdapter())
                //网络库接口
            .setHttpAdapter(DefaultWXHttpAdapter())
                .build()
            WXSDKEngine.initialize(this, config)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("queen", "e:$e")
        }
    }

}