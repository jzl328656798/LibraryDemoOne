package com.example.applibrary.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * CreateTime: 2019-08-03 - 19:12
 * Author: Queen
 * Date: 2019-08-03
 * Time: 19:12
 * Describe: item adapter
 */
class RViewAdapter<T>(list: ArrayList<T>) : RecyclerView.Adapter<RViewHolder>() {

    private val itemStyle: RViewItemManager<T> = RViewItemManager()
    private var itemListener: ItemListener<T>? = null
    private var dataList: ArrayList<T> = list

    constructor(list: ArrayList<T>, item: RViewItem<T>) : this(list) {
        dataList = list
        itemStyle.addStyles(item)
    }

    fun addStyles(item: RViewItem<T>) {
        itemStyle.addStyles(item)
    }

    fun addData(list: ArrayList<T>) {
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    fun update(list: ArrayList<T>) {
        dataList = list
        notifyDataSetChanged()
    }

    private fun hasMultiStyle() = itemStyle.getItemViewStylesCount() > 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val item = itemStyle.getRViewItem(viewType)
        val holder = RViewHolder.createViewHolder(parent.context, parent, item.getItemLayout())
        if (item.openClick()) setListener(holder)
        return holder
    }

    fun setItemListener(itemListener: ItemListener<T>){
        this.itemListener = itemListener
    }

    private fun setListener(holder: RViewHolder) {
        holder.getConvertView().setOnClickListener { view ->
            itemListener?.onItemClick(view, dataList[holder.adapterPosition], holder.adapterPosition)
        }
        holder.getConvertView().setOnLongClickListener { view ->
            itemListener?.run { this.onItemLongClick(view, dataList[holder.adapterPosition], holder.adapterPosition) } ?: false
        }
    }

    override fun getItemCount() = dataList.size

    override fun getItemViewType(position: Int): Int {
        if (hasMultiStyle()) return itemStyle.getItemViewType(dataList[position], position)
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        convert(holder,dataList[position])
    }

    private fun convert(holder: RViewHolder,entity:T){
        itemStyle.convert(holder,entity,holder.adapterPosition)
    }
}