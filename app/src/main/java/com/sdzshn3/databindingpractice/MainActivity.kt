package com.sdzshn3.databindingpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sdzshn3.databindingpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val bind = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        bind.lifecycleOwner = this
        bind.viewModel = viewModel
        bind.recyclerViewExpBtn.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}