package library.demo.one.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity1.*



/**
 * CreateTime: 2019-08-22 - 16:16
 * Author: Queen
 * Date: 2019-08-22
 * Time: 16:16
 * Describe: test1
 */
class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(library.demo.one.R.layout.activity1)
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.i("queen","hasFocus:$hasFocus")
        if (hasFocus){
            initTestData()
        }
    }

    private fun initTestData() {
        val x = tv_test_data.x
        val y = tv_test_data.y

        val top = tv_test_data.top
        val bottom = tv_test_data.bottom

        val left = tv_test_data.left
        val right = tv_test_data.right

        val tx = tv_test_data.translationX
        val ty = tv_test_data.translationY
        val tz = tv_test_data.translationZ

        Log.i("queen", "x:$x")
        Log.i("queen", "y:$y")

        Log.i("queen", "top:$top")
        Log.i("queen", "bottom:$bottom")

        Log.i("queen", "left:$left")
        Log.i("queen", "right:$right")

        Log.i("queen", "tx:$tx")
        Log.i("queen", "ty:$ty")
        Log.i("queen", "tz:$tz")

        Log.i("queen", "100dp:${dip2px(100f)}")
    }


    private fun dip2px(dipValue: Float): Int {
        val scale = resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }
}