package library.demo.viewlibrary.verify.code

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.phone_verify_code.view.*
import library.demo.viewlibrary.R

/**
 * Created by queen on 2019-07-30.
 * CreateTime: 2019-07-30 - 17:13
 * Author: Queen
 * Date: 2019-07-30
 * Time: 17:13
 * Describe: 手机验证码
 */
class PhoneVerifyCode : RelativeLayout {

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {

        LayoutInflater.from(context).inflate(R.layout.phone_verify_code, this, true)

        //ll_verify_text
        //ll_verify_line

        for (i in 1..6) {
            ll_verify_text.addView(createTextView())
        }
    }

    private fun createTextView(): TextView {
        val textView = TextView(context)
        textView.text = "111"
        val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.weight = 1f
        textView.layoutParams = params
        textView.gravity = Gravity.CENTER
        textView.textSize = 18f
        textView.setBackgroundResource(R.color.material_blue_grey_800)
        textView.setTextColor(context.resources.getColor(R.color.view_library_while,null))
        return textView
    }
}