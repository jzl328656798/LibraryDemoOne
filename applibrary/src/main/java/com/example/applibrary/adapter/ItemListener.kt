package com.example.applibrary.adapter

import android.view.View

/**
 * CreateTime: 2019-08-03 - 19:09
 * Author: Queen
 * Date: 2019-08-03
 * Time: 19:09
 * Describe: item click
 */
interface ItemListener<T> {

    fun onItemClick(view: View, entity: T, position: Int)

    fun onItemLongClick(view: View, entity: T, position: Int): Boolean

}