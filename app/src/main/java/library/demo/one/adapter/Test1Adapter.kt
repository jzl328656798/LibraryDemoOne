package library.demo.one.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import library.demo.one.R
import library.demo.one.holder.Test1ViewHolder

/**
 * CreateTime: 2019-08-22 - 16:54
 * Author: Queen
 * Date: 2019-08-22
 * Time: 16:54
 * Describe: test1
 */
class Test1Adapter(private val data: ArrayList<String>) : RecyclerView.Adapter<Test1ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Test1ViewHolder {
        return Test1ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_test1, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Test1ViewHolder, position: Int) {
    }
}