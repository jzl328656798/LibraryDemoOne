package library.demo.one.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import library.demo.one.R
import library.demo.one.holder.Test2ViewHolder

/**
 * CreateTime: 2019-08-22 - 16:54
 * Author: Queen
 * Date: 2019-08-22
 * Time: 16:54
 * Describe: test2
 */
class Test2Adapter(private var data: ArrayList<String>?) : RecyclerView.Adapter<Test2ViewHolder>() {

    fun setData(data: ArrayList<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Test2ViewHolder {
        return Test2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_test2, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: Test2ViewHolder, position: Int) {
    }
}