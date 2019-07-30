package library.demo.viewlibrary.verify.code

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
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
    }
}