package com.example.ex6_jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex6_jetpack.databinding.ActivityMainBinding
import com.example.ex6_jetpack.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //첫번째 페이지로 이동
        binding.move1.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        //업버튼 (뒤로가기 생성)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    //업버튼 클릭시 자동으로 호출되는 함수 재정의
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}