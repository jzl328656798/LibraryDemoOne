package com.example.applibrary.net

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest

/**
 * Author: Queen
 * Date: 2019-11-12 16:49
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
 * Describe: NetworkManager
 */
object NetworkManager {

    fun initNetworkListener(application: Application, listener: NetworkListener? = null) {
        val network = NetworkCallbackImpl(listener)
        val build = NetworkRequest.Builder()

        val request = build.build()
        val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.registerNetworkCallback(request, network)
    }

}