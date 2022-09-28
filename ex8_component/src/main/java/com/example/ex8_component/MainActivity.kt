package com.example.ex8_component

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ex8_component.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //액티비티가 종료 비활성화 될 때
    override fun onDestroy() {
        Log.d("myLog", "onDestroy")
        super.onDestroy()
    }

    //액티비티가 활성화 될 때 onPause()보다 뒤에 실행
    override fun onStop() {
        Log.d("myLog", "onStop")
        super.onStop()
    }

    //액티비티가 일지정지 상태일때
    override fun onPause() {
        Log.d("myLog","onPause")
        super.onPause()
    }

    override fun onStart() {
        //액티비티가 실행 (재실행) 될때
        Log.d("myLog","onStart")
        super.onStart()
    }

    override fun onResume() {
        //액티비티가 실행 (재실행) 될때 2 실행시킨이후
        Log.d("myLog","onResume")
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //앱 실행시 최초 한번만 호출
        Log.d("myLog","onCreate")

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터 다시 돌려 받을 때 2
        //런처를 만들었다
        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val resultData = it.data?.getStringExtra("result")
            Log.d("myLog","데이터 다시 돌려 받을 때 2 : ${resultData}")
        }


        binding.goTwo.setOnClickListener {
            val intent = Intent(this,TwoActivity::class.java)
            //intent  사용 기본
             /*startActivity(intent)*/

            //인텐트에 엑스트라 데이터 추가
            /*val intent = Intent(this, TwoActivity::class.java)
            intent.putExtra("data1", "엑스트라 데이터")
            intent.putExtra("data2", 22)
            startActivity(intent)*/

            //데이터를 다시 돌려 받을 때 1:
       /*     intent.putExtra("data1","데이터 돌려받기")
            intent.putExtra("data2",1)
            startActivityForResult(intent,20)*/

            //데이터 다시 돌려 받을 때 2:
            intent.putExtra("data1","데이터 돌려받기")
            intent.putExtra("data2",1)
            requestLauncher.launch(intent)

        }
    }
    //데이터를 다시 돌려 받을 때
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 20 && resultCode == Activity.RESULT_OK){
            val result = data?.getStringExtra("result")
            Log.d("myLog","데이터 돌려 받기 1 : ${result}")
        }
    }
}