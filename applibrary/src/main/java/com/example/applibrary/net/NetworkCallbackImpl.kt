package com.example.applibrary.net

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log

/**
 * Author: Queen
 * Date: 2019-11-12 16:47
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
 * Describe: 网络监听
 */
class NetworkCallbackImpl(private val listener: NetworkListener? = null) : ConnectivityManager.NetworkCallback() {


    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        Log.i("queen", "网络已经连接")
        listener?.connectState(true)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        Log.i("queen", "网络已经断开")
        listener?.connectState(false)
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            when {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i("queen", "网络发生变化，当前类型为：wifi")
                    listener?.connectType(NetworkType.WIFI)
                }
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i("queen", "网络发生变化，当前类型为：可能是4G")
                    listener?.connectType(NetworkType.MOBILE)
                }
                else -> {
                    Log.i("queen", "网络发生变化，当前类型为：可能是其他网络")
                    listener?.connectType(NetworkType.OTHER)
                }
            }
        }
    }
}