package com.example.applibrary.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.applibrary.manager.AppManager

/**
 * Author: Queen
 * Date: 2019-11-21 15:21
 * Describe: Activity管理
 */
class AppActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    private val tag = "queen"

    override fun onActivityPaused(activity: Activity?) {
        LogTrace.i(tag, "onActivityPaused:$activity ------ ${System.currentTimeMillis()}")
    }

    override fun onActivityResumed(activity: Activity?) {
        LogTrace.i(tag, "onActivityResumed:$activity ------ ${System.currentTimeMillis()}")
    }

    override fun onActivityStarted(activity: Activity?) {
        LogTrace.i(tag, "onActivityStarted:$activity ------ ${System.currentTimeMillis()}")
    }

    override fun onActivityDestroyed(activity: Activity?) {
        LogTrace.i(tag, "onActivityDestroyed:$activity ------ ${System.currentTimeMillis()}")
        if (activity != null) AppManager.removeActivity(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        LogTrace.i(tag, "onActivitySaveInstanceState:$activity ------ ${System.currentTimeMillis()}")
    }

    override fun onActivityStopped(activity: Activity?) {
        LogTrace.i(tag, "onActivityStopped:$activity ------ ${System.currentTimeMillis()}")
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        LogTrace.i(tag, "onActivityCreated:$activity ------ ${System.currentTimeMillis()}")
        if (activity != null) AppManager.addActivity(activity)
    }

}