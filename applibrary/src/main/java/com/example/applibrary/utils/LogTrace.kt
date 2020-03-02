package com.example.applibrary.utils

import android.util.Log

/**
 * Author: Queen
 * Date: 2019-11-21 15:21
 * Describe: 日志管理
 */
object LogTrace {

    private val printLog = true//是否打开LOG

    fun d(tag: String, message: String) {
        if (printLog) Log.d(tag, message)
    }

    fun i(tag: String, message: String) {
        if (printLog) Log.i(tag, message)
    }

    fun e(tag: String, message: String) {
        if (printLog) Log.e(tag, message)
    }

    fun longLog(tag: String, msg: String) {
        if (printLog) {
            var mag = msg
            val max_str_length = 2001 - tag.length
            while (mag.length > max_str_length) {
                Log.i(tag, mag.substring(0, max_str_length))
                mag = mag.substring(max_str_length)
            }
            Log.i(tag, mag)
        }
    }
}