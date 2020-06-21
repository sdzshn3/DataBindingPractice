package com.sdzshn3.databindingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sdzshn3.databindingpractice.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<ActivityRecyclerViewBinding>(this, R.layout.activity_recycler_view)

        val adapter = Adapter()
        bind.adapter = adapter

        val viewModel = ViewModelProvider(this)[RecyclerViewModel::class.java]
        bind.recyclerView.setHasFixedSize(false)

        viewModel.androids.observe(this, Observer {
            adapter.submitList(ArrayList(it))
        })
    }
}