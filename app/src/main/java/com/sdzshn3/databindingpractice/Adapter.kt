package com.sdzshn3.databindingpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sdzshn3.databindingpractice.databinding.ItemLayoutBinding


class Adapter : ListAdapter<Android, Adapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Android>() {
                override fun areItemsTheSame(oldItem: Android, newItem: Android): Boolean {
                    return oldItem.name == newItem.name
                }

                override fun areContentsTheSame(oldItem: Android, newItem: Android): Boolean {
                    //According to CodingWithMitch
                    return oldItem == newItem
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = DataBindingUtil.inflate<ItemLayoutBinding>(inflater, R.layout.item_layout, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.android = getItem(position)
    }

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}