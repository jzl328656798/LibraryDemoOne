package library.demo.one.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ContentFrameLayout
import library.demo.one.R

/**
 * Author: Queen
 * Date: 2019-11-14 14:55
 * Describe: BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    private var rootView: LinearLayout? = null
    private var networkView: View? = null
    private var networkConnectState = true

    fun i(message: String) {
        Log.i(tag, message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    fun showNetworkConnectState(state: Boolean) {
        try {
            if (networkConnectState != state) {
                networkConnectState = state
                if (rootView == null) {
                    rootView = findViewById<ContentFrameLayout>(android.R.id.content).parent.parent.parent as LinearLayout
                }
                if (networkView == null) {
                    networkView = LayoutInflater.from(this).inflate(R.layout.item_test1, null)
                }

                if (state) {
                    val childAt = rootView?.getChildAt(0)
                    if (childAt == networkView) {
                        runOnUiThread { rootView?.removeViewAt(0) }
                    }
                } else {
                    val childAt = rootView?.getChildAt(0)
                    if (childAt != networkView) {
                        runOnUiThread { rootView?.addView(networkView, 0) }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}