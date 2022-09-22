package com.example.ex4_resource

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowMetrics
import com.example.ex4_resource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //화면 크기정보 확인
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){ // R = 11 버전 , S = 12버전
            //30버전 (코드 R, 안드로이드 11) 부터는 WindowMetrics를 이용
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            Log.d("myLog","""30버전 이후 화면 크기 확인 :
            | width : ${windowMetrics.bounds.width()},
            | height : ${windowMetrics.bounds.height()}
        """.trimMargin())
        }else{
            //30버전 이전에는 DisplayMetrics를 이용
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display.getRealMetrics(displayMetrics)
            Log.d("myLog","""30버전 이전 화면 크기 확인 :
            | width : ${displayMetrics.widthPixels},
            | height : ${displayMetrics.heightPixels}
        """.trimMargin())


        }

    }
}