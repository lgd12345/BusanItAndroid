package com.example.ex8_component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ex8_component.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //엑스트라 데이터 받기
        val intent = intent
        val exData1 = intent.getStringExtra("data1")
        val exData2 = intent.getIntExtra("data2", 0)
        Log.d("myLog", "엑스트라확인 : ${exData1}, ${exData2}입니다.")

        binding.goHome.setOnClickListener{
            //인텐트 기본 사용
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)

            //데이터 돌려주기 2]
            intent.putExtra("result","결과값")
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}