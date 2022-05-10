package com.androidapp.module.home.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.androidapp.module.home.model.bean.Data

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/10/9 5:28 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class ProjectAdapter:PagingDataAdapter<Data, ProjectAdapter.ViewHolder>(COMPARATOR) {


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = getItem(position)
        if (repo != null) {
            holder.name.text = repo.title
            holder.description.text = repo.desc
            holder.starCount.text = repo.projectLink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_project_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name_text)
        val description: TextView = itemView.findViewById(R.id.description_text)
        val starCount: TextView = itemView.findViewById(R.id.star_count_text)

    }
}