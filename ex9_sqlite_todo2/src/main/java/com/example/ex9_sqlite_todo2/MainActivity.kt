package com.example.ex9_sqlite_todo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex9_sqlite_todo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var datas: MutableList<String>? = null
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //AddActivity에서 intent에 putExtra해준거에서 result값을 받는다.
        //requestLauncher 생성
        val requestLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { //contract
                it.data!!.getStringExtra("result")?.let {//callback
                    //let 사용해서 데이터 자체를 다룸 , 데이터가 절대 null이 아니라는 것을 명시하기 위해서 !!를 써준다.
                    //사용자가 값을 입력하고 넘어온 상태이기 때문이다.
                    datas?.add(it)
                    adapter.notifyDataSetChanged()
                }
            }
        binding.mainFab.setOnClickListener {
//addActivity를 인텐트에 담아서 시스템에 전달
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }
        datas = savedInstanceState?.let {
            //번들객체에 데이터가 있을 때
            it.getStringArrayList("datas")?.toMutableList()
        } ?: let {
            // it.getStringArrayList("datas")?.toMutableList()
            //        } 이게 널이면 mutableListOf<String>()를 실행시킨다. 엘비스연산자(?:)는 왼쪽이 null이면 null을 반환
            //번들객체에 데이터가 null일 때
            mutableListOf<String>()
        }
        //DB에서 데이터를 가져온다.
        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from TODO_TB", null)
        cursor.run {
            while (moveToNext()){
                datas?.add(cursor.getString(1))
            }
        }
        db.close()

        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager = layoutManager
        adapter = MyAdapter(datas)
        binding.mainRecyclerView.adapter = adapter
        binding.mainRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("datas", ArrayList(datas))

    }
}