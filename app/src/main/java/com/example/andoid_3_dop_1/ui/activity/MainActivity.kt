package com.example.andoid_3_dop_1.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.andoid_3_dop_1.R
import com.example.andoid_3_dop_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupObserve()
        setupListener()
    }

    private fun setupObserve() {
        viewModel?.number?.observe(this) {
            binding.countText.text = it.toString()
        }
    }

    private fun setupListener() {
        binding.btnPlus.setOnClickListener {
            viewModel?.setPlus()
            if (viewModel?.count == 10 || viewModel?.count == -10) {
                binding.countText.setTextColor(resources.getColor(R.color.purple_700))
            } else {
                binding.countText.setTextColor(resources.getColor(R.color.white))
            }

            binding.btnMinus.setOnClickListener {
                viewModel?.setMinus()
                if (viewModel?.count == 10 || viewModel?.count == -10) {
                    binding.countText.setTextColor(resources.getColor(R.color.purple_700))
                } else {
                    binding.countText.setTextColor(resources.getColor(R.color.white))
                }
            }
        }
    }
}