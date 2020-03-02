package com.example.applibrary.net

/**
 * Author: Queen
 * Date: 2019-11-21 14:47
 * Describe: 网络监听会掉
 */
interface NetworkListener {

    fun connectState(state: Boolean)

    fun connectType(type: NetworkType)
}