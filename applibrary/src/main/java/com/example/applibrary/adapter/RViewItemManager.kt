package com.example.applibrary.adapter

import android.util.SparseArray
import androidx.core.util.forEach
import java.lang.RuntimeException

/**
 * CreateTime: 2019-08-03 - 19:14
 * Author: Queen
 * Date: 2019-08-03
 * Time: 19:14
 * Describe: item manager
 */
class RViewItemManager<T> {

    private val styles: SparseArray<RViewItem<T>> = SparseArray()

    fun addStyles(item: RViewItem<T>) {
        styles.put(styles.size(), item)
    }

    fun getItemViewStylesCount() = styles.size()

    fun getItemViewType(entity: T, position: Int): Int {
        styles.forEach { key, value ->
            if (value.isItemView(entity, position)) {
                return styles.keyAt(key)
            }
        }
        throw RuntimeException("位置：$position 没有匹配的布局类型")
    }

    fun getRViewItem(viewType: Int): RViewItem<T> {
        return styles.get(viewType)
    }

    /**
     * 视图和数据源绑定
     */
    fun convert(holder: RViewHolder, entity: T, position: Int) {
        styles.forEach { _, value ->
            if (value.isItemView(entity, position)) {
                value.convert(holder, entity, position)
                return
            }
        }
        throw RuntimeException("位置：$position 没有匹配的布局类型")
    }

}