package com.example.ex9_sqlite_todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex9_sqlite_todo.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}