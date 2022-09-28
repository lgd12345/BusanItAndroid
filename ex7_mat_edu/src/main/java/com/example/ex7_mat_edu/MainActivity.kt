package com.example.ex7_mat_edu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.ListFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ex7_mat_edu.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var adapter:MyFragmentPagerAdapter

    class MyFragmentPagerAdapter(activity: FragmentActivity):FragmentStateAdapter(activity){
        val fragments:List<Fragment>
        init{
            fragments = listOf(OneFragment(),TwoFragment(),ThreeFragment())
        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //소스코드에서 탭버튼 정의
        /* val tabLayout = binding.tabs
         val tab1 : TabLayout.Tab = tabLayout.newTab()
         tab1.text = "탭1"
         tabLayout.addTab(tab1)

         val tab2 : TabLayout.Tab = tabLayout.newTab()
         tab2.text = "탭2"
         tabLayout.addTab(tab2)

         val tab3 : TabLayout.Tab = tabLayout.newTab()
         tab3.text = "탭3"
         tabLayout.addTab(tab3)*/

    /*    //탭버튼의 이벤트 핸들러 추가
        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            *//*탭버튼을 선택할 때 이벤트*//*
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                Log.d("myLog","탭버튼 선택: ${tab?.text}")
                when (tab?.text) {
                    "탭1" -> {
                        transaction.replace(R.id.content, OneFragment())
                    }
                    "탭2" -> {
                        transaction.replace(R.id.content, TwoFragment())
                    }
                    "탭3" -> {
                        transaction.replace(R.id.content, ThreeFragment())
                    }
                }
                transaction.commit()
            }

            // 선택된 탭 버튼을 다시 선택할 때 이벤트
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            //다른 탭 버튼을 눌러 선택된 탭버튼이 해제될 때 이벤트
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        //뷰페이저 어댑터 적용
        adapter = MyFragmentPagerAdapter(this)
        binding.viewPager.adapter = adapter
        //탭 + 뷰페이저 연동
        TabLayoutMediator(binding.tabs, binding.viewPager){ tab, position ->
            tab.text = "Tab${position+1}"
        }.attach()*/

        //Drawable 레이아웃 메뉴에 이벤트 추가
        binding.naviMenu.setNavigationItemSelectedListener {
            Log.d("myLog","네이게이션 아이템 선택: ${it.title}")
            when(it.title){
                "아이템1" -> {
                    /*val intent = Intent(this, ::class.java)
                    startActivity(intent)*/
                }
            }
            true
        }
binding.efb.setOnClickListener{
    when(binding.efb.isExtended){ //아이콘  + 문자열 전부 표시 여부 체크
        true -> binding.efb.shrink()  //확장되어있다 : 아이콘만표시(+)
        false -> binding.efb.extend() //확장되어있지 않다: 아이콘(+) + 문자열("플로팅 액션 버튼")
    }
}


    }
}