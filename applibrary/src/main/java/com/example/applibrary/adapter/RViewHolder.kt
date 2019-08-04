package com.example.applibrary.adapter

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * CreateTime: 2019-08-03 - 18:09
 * Author: Queen
 * Date: 2019-08-03
 * Time: 18:09
 * Describe: adapter viewHolder
 */
class RViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mViews: SparseArray<View> = SparseArray()
    private val mConvertVIew: View = itemView

    companion object {
        fun createViewHolder(context: Context, parent: ViewGroup, layoutId: Int): RViewHolder {
            return RViewHolder(
                LayoutInflater.from(context).inflate(
                    layoutId,
                    parent,
                    false
                )
            )
        }
    }

    fun <T : View> getView(viewId: Int): T {
        var view = mViews.get(viewId)
        if (view == null) {
            view = mConvertVIew.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as T
    }

    fun getConvertView() = mConvertVIew
}