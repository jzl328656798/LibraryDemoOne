package com.example.applibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Author: Queen
 * Date: 2019-11-22 14:50
 * Describe: ListView 适配器
 * data 数据集合
 * layoutId 布局ID
 */
abstract class LViewAdapter<T>(private val data: MutableList<T>, private val layoutId: Int) : BaseAdapter() {


    /**
     * 删除条目
     */
    fun deleteItem(position: Int) {
        data.removeAt(position)
        notifyDataSetChanged()
    }

    /**
     * 添加数据
     *
     */
    fun addData(data: MutableList<T>, addFirst: Boolean = true) {
        if (addFirst) {
            this.data.clear()
        }
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    /**
     * 添加一条数据
     */
    fun addItem(t: T) {
        this.data.add(t)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: LViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(layoutId, parent, false)
            viewHolder = LViewHolder()
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as LViewHolder
        }
        setConvertView(viewHolder, getItem(position), position)
        return view
    }

    override fun getItem(position: Int): T {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    abstract fun setConvertView(viewHolder: LViewHolder, t: T, position: Int)
}