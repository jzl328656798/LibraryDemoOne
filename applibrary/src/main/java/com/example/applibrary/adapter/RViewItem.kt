package com.example.applibrary.adapter

/**
 * CreateTime: 2019-08-03 - 18:00
 * Author: Queen
 * Date: 2019-08-03
 * Time: 18:00
 * Describe: item interface
 */
interface RViewItem<T> {

    /**
     * 获取item的布局
     */
    fun getItemLayout(): Int

    /**
     * 是否可以点击
     */
    fun openClick(): Boolean

    /**
     * 是否为当前的item布局
     */
    fun isItemView(entity: T, position: Int): Boolean

    /**
     * item和数据类绑定
     */
    fun convert(holder: RViewHolder, entity: T, position: Int)


}