package com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        //add observer
        viewModel.name.observe(this, Observer { name->
            binding.tvName.text =name.toString()
        })
        viewModel.age.observe(this, Observer {age->
            binding.tvAge.text=age.toString()
        })

        binding.btnResult.setOnClickListener {
            viewModel.updateName(binding.etName.text.toString())
            viewModel.updateAge(binding.etAge.text.toString().toInt())
        }
    }
}