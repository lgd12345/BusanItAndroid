package com.example.ex1_kakaologin_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ex1_kakaologin_page.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding 기법으로 변경
        // 바인딩 객체 획득 : 첫글자와 _뒤에오는 글자를 대문자로 만들고
        // binding을 붙인다.
        //layoutInflater : XML에 미리 정의해둔 틀을 실제 메모리에 올려주는 역할
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}