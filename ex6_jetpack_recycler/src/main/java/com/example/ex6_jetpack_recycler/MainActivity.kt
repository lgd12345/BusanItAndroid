package com.example.ex6_jetpack_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ex6_jetpack_recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //임의의 데이터 생성
        val datas = mutableListOf<String>()
        for (i in 1..10) {
            //원본소스
            // datas.add("아이템${i}")


            //StaggeredGridLayoutManager 테스트를 위한 데이터 준비
            if (i == 3 || i == 4 || i == 6 || i == 8) {
                datas.add("동해물과 백두산이 마르고 닳도록")
            } else {
                datas.add("아이템${i}")
            }
        }
        adapter = MyAdapter(datas)


        //LinearLaoutManager 사용
//        val layoutManager = LinearLayoutManager(this)
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //       layoutManager.orientation = LinearLayoutManager.VERTICAL
        //       binding.recyclerView.layoutManager = layoutManager

        //GridLayoutManager
        //true 역순 , false 정방향
        /*  val GridLayoutManager = GridLayoutManager(
              this,
              3,
              GridLayoutManager.HORIZONTAL,
              false
          )
          binding.recyclerView.layoutManager = GridLayoutManager*/

        //StaggeredGridLayoutManager 사용
        /* val layoutManager = StaggeredGridLayoutManager(
             2, StaggeredGridLayoutManager.VERTICAL
         )*/

        //아이템 데코레이션 적용
//        binding.recyclerView.addItemDecoration(MyDecoration(this))

        //리사이클러 뷰 적용
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //바꿔서 적용
        // binding.recyclerView.layoutManager = layoutManager

        /*       binding.recyclerView.adapter = adapter
               binding.recyclerView.addItemDecoration(
                   DividerItemDecoration(
                       this,
                       LinearLayoutManager.VERTICAL
                   )
               )*/

        //viewPager2 적용 : 리사이클러뷰 어댑터를 이용
        // binding.viewPager.adapter = adapter

        //viewPager2 적용 : 플래그먼트 어댑터를 이용
        binding.viewPager.adapter = MyfragmentPagerAdapter(this)

        //새로운 아이템 추가
        //       binding.addItem.setOnClickListener {
        //           adapter.addItem()
        //       }
        //아이템 삭제
        //       binding.removeItem.setOnClickListener {
        //          adapter.removeItem3()
        //      }
    }
}