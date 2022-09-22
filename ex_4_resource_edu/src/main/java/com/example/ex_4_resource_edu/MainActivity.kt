package com.example.ex_4_resource_edu

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowMetrics
import androidx.core.content.res.ResourcesCompat
import com.example.ex_4_resource_edu.databinding.ActivityMain2Binding
import com.example.ex_4_resource_edu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //R파일에서 리소스 사용하기(소스코드에서 사용시)
        //R.폴더명(id).value(name)의 형태로 리소스를 사용한다.
        //binding.textView.text = getString(R.string.app_name)
        //binding.textView.setTextColor(ResourcesCompat.getColor(resources, R.color.myColor,null))

    //화면 크기정보 확인
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){ // R = 11 버전 , S = 12버전
        //30버전 (코드 R, 안드로이드 11) 부터는 WindowMetrics를 이용
        val windowMetrics:WindowMetrics = windowManager.currentWindowMetrics
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