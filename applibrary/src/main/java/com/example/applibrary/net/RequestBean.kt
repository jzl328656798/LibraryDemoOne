package com.example.applibrary.net

import com.google.gson.JsonObject

/**
 * Author: Queen
 * Date: 2019-11-20 17:28
 * Describe: 请求数据类
 */
data class RequestBean(val url: String,val body:JsonObject,val header:Map<String,String>) {

}