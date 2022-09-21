package com.example.ex3_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.example.ex3_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //터치이벤트
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //Log.d("myLog","터치 이벤트 발생")

        //터치 이벤트 좌표값 얻기 : MotionEvent 객체로 획득
        //x : 이벤트가 발생한 뷰의 x 좌표
        //y : 이벤트가 발생한 뷰의 y 좌표
        //Log.d("myLog","x의 좌표 값: ${event?.x},y의 좌표 값: ${event?.y}")

        //터치 이벤트의 종류
        //그림 그리는 어플 같은 곳에서 사용된다.
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> { //클릭을 한 상태
                Log.d("myLog", "ACTION_DOWN")
            }
            MotionEvent.ACTION_UP -> { // 마우스를 손가락에서 뗀 순간
                Log.d("myLog", "ACTION_UP")
            }
            MotionEvent.ACTION_MOVE -> { // 화면을 드래그 할 때
                Log.d("myLog", "ACTION_MOVE")
            }
        }
        return super.onTouchEvent(event)
    }

    //키이벤트(소프트 키보드가 아님)
// 뒤로가기 버튼, 볼륨 업다운 버튼
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("myLog", "키가 눌렸을 때 발생")
        return super.onKeyDown(keyCode, event)
    }

    //볼륨 업 다운
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("myLog", "키가 뗐을 때 발생")
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                Log.d("myLog", "KEYCODE_VOLUME_UP ")
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Log.d("myLog", "KEYCODE_VOLUME_DOWN ")
            }
        }
        return super.onKeyUp(keyCode, event)
    }

    //뒤로가기
    override fun onBackPressed() {
        Log.d("myLog", "뒤로가기 버튼 클릭")
        super.onBackPressed()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1.액티비티에서 인터페이스 구현
        binding.btn.setOnClickListener(this)
        //2.별도의 핸들러 구현
        binding.btn2.setOnClickListener(Handler())
        //3.SAM기법으로 구현
        binding.btn3.setOnClickListener {
            Log.d("myLog", "버튼터치3")
        }
        //롱 클릭 이벤트
        binding.btn3.setOnLongClickListener {
            Log.d("myLog", "길게 버튼터치3")
            true
        }
        //좋아요 버튼 만들어보기 - 이벤트 처리
        binding.unlike.setOnClickListener {
            binding.unlike.visibility = View.GONE
            binding.like.visibility = View.VISIBLE
        }
        //좋아요 끌때 길게 누르기
        binding.like.setOnLongClickListener {
            binding.unlike.visibility = View.VISIBLE
            binding.like.visibility = View.GONE
            true
        }
    }

    //1. 액티비티에서 인터페이스 구현
    override fun onClick(p0: View?) {
        Log.d("myLog", "버튼터치1")
    }
}

class Handler : View.OnClickListener {
    override fun onClick(p0: View?) {
        Log.d("myLog", "버튼터치2")
    }

}