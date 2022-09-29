package com.example.ex8_component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.example.ex8_component.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //이런식의 사용을 ex) 카카오톡 프로필 사진 등록시 편집화면에서 사진 앨범에 접속했다가 다시
        // 편집화면에 돌아와서 등록하는 경우가 있는데 그럴 때 쓰이게 된다.

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
//        키보드 올리고 내리기
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.showBtn.setOnClickListener{
            //포커스는 커서 깜빡거리기
            binding.editView.requestFocus()
            manager.showSoftInput(binding.editView, InputMethodManager.SHOW_IMPLICIT)
        }
        binding.hideBtn.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}