package com.example.applibrary.manager

import android.app.Activity
import java.util.*

/**
 * Author: Queen
 * Date: 2019-11-21 15:18
 * Describe: App Activity 管理
 */
object AppManager {

    private val activityStack = Stack<Activity>()

    /**
     * 添加 Activity
     */
    fun addActivity(activity: Activity) = activityStack.add(activity)

    /**
     * 删除 Activity
     */
    fun removeActivity(activity: Activity) = activityStack.remove(activity)

    /**
     * 获取最顶端 Activity
     */
    fun getTopActivity() = if (activityStack.empty()) null else activityStack.lastElement()

    /**
     * 结束全部 Activity
     */
    fun finishAllActivity() {
        activityStack.forEach { it.finish() }
        activityStack.clear()
    }
}