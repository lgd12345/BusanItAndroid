package com.example.ex2_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ex2_layout.databinding.ActivityMainBinding
import com.example.ex2_layout.databinding.FrameTestBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*FrameTestBinding 파일이름이었다!!!!*/
        val binding = FrameTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            binding.btn.visibility = View.GONE
            binding.img.visibility = View.VISIBLE
        }
        binding.img.setOnClickListener {
            binding.img.visibility = View.GONE
            binding.btn.visibility = View.VISIBLE
        }
    }
}