package com.example.ex1_view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ex1_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding 기법으로 변경
        // 바인딩 객체 획득 : 첫글자와 _뒤에오는 글자를 대문자로 만들고
        // binding을 붙인다.
        //layoutInflater : XML에 미리 정의해둔 틀을 실제 메모리에 올려주는 역할
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 출력할 화면을 설정한다. ->  setContentView함수
        /*setContentView(R.layout.activity_main)*/
        /*setContentView(R.layout.text_view)*/
        /*setContentView(R.layout.button_view)*/
        /*setContentView(R.layout.edit_text_view)*/

        //TextView생성-1.일반적인 방법
        val name = TextView(this)
        name.typeface = Typeface.DEFAULT_BOLD
        name.textSize = 30F
        name.text = "Lake Louis"

        //TextView생성-2. apply키워드를 사용한 방법
        //apply키워드 이용시 해당객체의 속성을 바로 설정 가능.(변수.~로 안불러도 된다.)
//        val name = TextView(this).apply {
//            typeface = Typeface.DEFAULT_BOLD //폰트 굵게
//            textSize = 30F //30F로 폰트 사이즈
//            text = "Lake Louis" //화면에 출력할 글자
//        }
        //이미지 출력 ImageView 생성
        //also키워드 이용 -> it.~ 로 해당 객체를 이용한다.
//        val image = ImageView(this).also {
//            it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.lake_1))
//            it.adjustViewBounds = true
//        }
        val image = ImageView(this)
        //이미지 세팅 -> R(리소스)안에 있는 리소스파일을 선택 할 수 있다.
        //1.setImageDrawable -> 네트워크나 파일을 읽어서 이미지를 그린다.
        //2.setImageResource -> res폴더에 있는 리소스를 가져온다.
//        image.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.lake_1))
        image.setImageResource(R.drawable.lake_1)
        image.adjustViewBounds = true //이미지의 세로길이에 맞춰서 비율을 맞춰준다.

        //주소 문자열 출력 TextView 생성
        val address = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            text = "Lake Louise, AB, 캐나다"
        }
        // 레이아웃을 생성하고, 뷰를 담아준다.
        val layout = LinearLayout(this).apply {
            // 뷰 배치 방향 설정 : orientation
            orientation = LinearLayout.VERTICAL
            // 뷰 정렬 설정 : gravity
            gravity = Gravity.CENTER
            //LinearLayout 객체에 TextView, ImageView, TextView 객체추가
            addView(name, WRAP_CONTENT, WRAP_CONTENT)
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(address, WRAP_CONTENT, WRAP_CONTENT)
        }
        // LinearLayout 객체를 화면에 출력
//        setContentView(layout)

        //id 속성을 이용한 특정뷰 제어 - findViewById()함수 이용
        //변수에 타입을 지정한 방법
//        val name1 : TextView = findViewById(R.id.name)
//        name1.text = "id 속성을 이용한 특정 뷰 제어"
//
//            //findViewById()함수에 제네릭을 추가한 방법
//        val address1 = findViewById<TextView>(R.id.address)
//        val image1 = findViewById<ImageView>(R.id.image1)
//
////함수로 세가지 버튼 만들어둠
//        val visibleBtn = findViewById<Button>(R.id.visible_test)
//        val invisibleBtn = findViewById<Button>(R.id.invisible_test)
//        val goneBtn = findViewById<Button>(R.id.gone_test)
//
//        visibleBtn.setOnClickListener {
//            image1.visibility = View.VISIBLE
//        }
//        invisibleBtn.setOnClickListener {
//            image1.visibility = View.INVISIBLE
//        }
//        goneBtn.setOnClickListener {
//            image1.visibility = View.GONE
//        }


        //id 속성을 이용한 특정뷰 제어 - 바인딩기법 활용
        // binding.id값 을 이용해서 뷰 제어 가능.(변수화가 필수가 (아님))
        val image1 = binding.image1

        val visibleBtn = binding.visibleTest
        visibleBtn.setOnClickListener {
            image1.visibility = View.VISIBLE
        }
        val invisibleBtn = binding.invisibleTest
        invisibleBtn.setOnClickListener {
            image1.visibility = View.INVISIBLE
        }
        binding.goneTest.setOnClickListener {
            image1.visibility = View.GONE
        }






    }
}