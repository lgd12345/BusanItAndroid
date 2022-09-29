package com.example.ex9_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.example.ex9_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dbHelper이용한 db객체 생성
        val db: SQLiteDatabase = DBHelper(this).writableDatabase

        //db 생성
        //      val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)
        //테이블 생성
        //execSQL : create, alter, drop, insert, update, delete문을 실행 하는 함수
        //테이블은 한번만 생성 실행이 가능하기 때문에 주석하고 입력값을 바꿔서 넣어줬다.
        /*    db.execSQL(
                "create table USER_DB(" +
                        "_id integer primary key autoincrement," +
                        "name not null," +
                        "phone)"
            )*/
        // insert문 실행
        /* db.execSQL("insert into USER_DB(name, phone) values(?,?)",
 arrayOf("kim", "01000000000")
)*/

        //ContenValues를 이용한 insert함수 사용
        /*   val valuse = ContentValues()
           valuse.put("name", "android")
           valuse.put("phone", "01000002222")
           db.insert("USER_DB", null, valuse)*/

        //select문 실행
        //rawQuery 함수 이용 : 반환값이 cursor 객체이다. (조회한 행의 집합)
//        val cursor = db.rawQuery("select * from USER_DB",null)
/*
        val cursor = db.query(
            "USER_DB",
            arrayOf("_id","name","phone"),
            null,
            null,
            null,
            null,
            null,
        )

        if(cursor != null){
            while (cursor.moveToNext()){
                //USER_DB 테이블에 컬럼이 _id(0) ,_name(1), _phone(2)
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                Log.d("myLog","id : ${id}, name : ${name}, phone : ${phone}")
            }
        }*/

        //등록 버튼 눌렀을 때 name, phone 값을 db에 저장
        // 아이디가 user인 텍스트 뷰에 입력받은 name, phone출력
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        binding.submit.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)

            val name = binding.name.text.toString()
            val phone = binding.phone.text.toString()
            binding.user.text = "입력 하신 이름은 : ${name} 이고, 전화번호는 : ${phone} 입니다."
            binding.name.text.clear()
            binding.phone.text.clear()

            db.execSQL("insert into USER_DB(name,phone) values(?,?)", arrayOf(name,phone))

            val cursor = db.query("USER_DB",
            arrayOf("name","phone"),
                "phone=?",
                arrayOf(phone),
                null,
                null,
                null
            )
            if (cursor != null){
                while (cursor.moveToNext()){
                    val name = cursor.getString(0)
                    val phone = cursor.getString(1)
                    Log.d("myLog","현재 입력한 데이터는 ${name}, ${phone}입니다.")
                }
            }
        }

    }
}