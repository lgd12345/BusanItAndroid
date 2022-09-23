package com.example.ex6_jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ex6_jetpack.databinding.ActivityMainBinding
import com.example.ex6_jetpack.databinding.ActivityTwoBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바사용
        setSupportActionBar(binding.toolbar)

        //두번째 페이지로 이동
        binding.moveTwo.setOnClickListener {
            val intent = Intent(this, TwoActivity::class.java)
            startActivity(intent)
        }
        //프래그먼트를 정용(제어)
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        val fragment = OneFragment()
        transaction.add(R.id.fragmentView,fragment)
        transaction.commit()
    }
    //메뉴 생성
    //가운데 숫자로 아이디값 설정
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //액티비티 클래스에서 메뉴 생성 - 소스코드로 생성
        /*val menu1:MenuItem? = menu?.add(0,0,0,"두번째 페이지로 이동")
        val menu2:MenuItem? = menu?.add(0,1,0,"메뉴2")*/

        //액티비티 클래스에서 메뉴 생성 - 메뉴 리소스 파일로 생성
        menuInflater.inflate(R.menu.menu_menu,menu)

        //서치뷰 검색기능 구현
        val searchMenu = menu?.findItem(R.id.menu3)
        val searchView = searchMenu?.actionView as SearchView // as : 뒤에오는 객체로 형변환
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("myLog","검색 이벤트 발생 :${query}")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("myLog","키보드의 입력값에 따라 실시간으로 출력 :${newText}")
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)
    }
    //메뉴 선택시 이벤트 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            0 -> {
                Log.d("myLog","0번 메뉴 선택")
                val intent = Intent(this, TwoActivity::class.java)
            startActivity(intent)
            }
            1 -> {
                Log.d("myLog","1번 메뉴 선택")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}