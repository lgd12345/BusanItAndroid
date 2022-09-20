package com.example.basickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //객체 생성할때 자바와는 다르게 new키워드가 없다.
        var testClass = ClassBasic("kim")
        testClass.some()
    }
}