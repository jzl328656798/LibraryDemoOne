package library.demo.one.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity8.*
import library.demo.one.base.BaseActivity
import org.apache.weex.IWXRenderListener
import org.apache.weex.WXSDKInstance
import org.apache.weex.common.WXRenderStrategy


open class Activity8 : BaseActivity(), IWXRenderListener {
    override fun onRefreshSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
        Log.i(tag, "onRefreshSuccess")
    }

    override fun onException(instance: WXSDKInstance?, errCode: String?, msg: String?) {
        Log.i(tag, "onException")
        Log.i(tag, "onException:  errCode:${errCode}   msg:${msg}")
    }

    override fun onViewCreated(instance: WXSDKInstance?, view: View?) {
        Log.i(tag, "onViewCreated")
        if (view?.parent != null) {
            (view.parent as ViewGroup).removeView(view)
        }
        if (container != null) {
            container.addView(view)
        }
    }

    override fun onRenderSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
        Log.i(tag, "onRenderSuccess")
    }

    private var mWXSDKInstance: WXSDKInstance? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(library.demo.one.R.layout.activity8)
        initView()
    }

    private fun initView() {
        mWXSDKInstance = WXSDKInstance(this)
        mWXSDKInstance?.registerRenderListener(this)
        val pageName = "WXSample"
        val bundleUrl = "http://dotwe.org/raw/dist/38e202c16bdfefbdb88a8754f975454c.bundle.wx"
        mWXSDKInstance?.renderByUrl(pageName, bundleUrl, null, null, WXRenderStrategy.APPEND_ASYNC)
    }

    override fun onStart() {
        super.onStart()
        mWXSDKInstance?.onActivityStart()
    }

    override fun onResume() {
        super.onResume()
        mWXSDKInstance?.onActivityResume()
    }

    override fun onPause() {
        super.onPause()
        mWXSDKInstance?.onActivityPause()
    }

    override fun onStop() {
        super.onStop()
        mWXSDKInstance?.onActivityStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mWXSDKInstance?.onActivityDestroy()
    }

}