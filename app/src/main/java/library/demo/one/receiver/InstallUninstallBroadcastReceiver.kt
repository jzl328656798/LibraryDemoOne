package library.demo.one.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Author: Queen
 * Date: 2019-11-22 17:26
 * Describe: TODO
 */
class InstallUninstallBroadcastReceiver : BroadcastReceiver() {

    private val tag = InstallUninstallBroadcastReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        /**
         * 获取（安装/替换/卸载）应用的 信息
         */
        var packages = intent?.dataString
        packages = packages?.split(":".toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray()?.get(1)

        when (intent?.action) {
            Intent.ACTION_PACKAGE_ADDED -> Log.d(tag, packages + "应用程序安装了，需要进行该应用安全扫描吗")
            Intent.ACTION_PACKAGE_REMOVED -> Log.d(tag, packages + "应用程序卸载了，需要清理垃圾有缓存吗")
            Intent.ACTION_PACKAGE_REPLACED -> Log.d(tag, packages + "应用程序覆盖了")
        }
    }
}