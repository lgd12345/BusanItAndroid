package com.example.ex10_networking

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.ex10_networking.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //api통신으로 데이터를 가져왔다.

        binding.getReq.setOnClickListener {
            var userListCall = MyApplication.networkService.doGetUserList("1")

            userListCall.enqueue(object:Callback<UserListModel> {

                override fun onResponse(
                    call: Call<UserListModel>,
                    response: Response<UserListModel>
                ) {
                    //통신이 성공했을 때 호출
                    if (response.isSuccessful){
                        //Log.d("myLog","네트워킹 성공 : ${response.raw()}")
                        var  userList = response.body()
                        Log.d("myLog","네트워킹 성공 : ${userList}")
                    }
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    //통신이 실패했을 때 호출
                    Log.d("myLog","네트워킹 실패")
                }

            })
        }
        binding.getPath.setOnClickListener {
            val userModel = MyApplication.networkService.test2(1)
            userModel.enqueue(object:Callback<ResponseData>{
                override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                    //통신이 성공했을 때

                    Log.d("myLog","getPath 네트워킹 성공 .raw : ${response.raw()}")
                    Log.d("myLog","getPath 네트워킹 성공 .body : ${response.body()}")
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    //통신이 실패했을 때
                    Log.d("myLog","getPath 네트워킹 실패")
                }

            })
        }
        binding.getQueryMap.setOnClickListener {
            val userModel = MyApplication.networkService.test3(
                mapOf("one" to "안드로이드", "two" to "스튜디오"),
                "sik"
            )
            userModel.enqueue(object :Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    // 통신이 성공했을 때
                    Log.d("myLog","get QueryMap 네트워킹 성공 : ${response.body()}")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    //통신이 실패했을 때
                    Log.d("myLog","get QueryMap 네트워킹 실패")
                }

            })
        }

        // 주소 "http://reqres.in/img/faces/1-image/jpg"
        //override 사이즈 200 200

        binding.glideTest.setOnClickListener {
            Glide.with(this)
                .load("https://reqres.in/img/faces/1-image.jpg")
                .override(400,400)//크기조절
                .placeholder(R.mipmap.ic_launcher_round)//이미지 로딩을 시작하기전에 보여줄 이미지
                .error(R.drawable.a789)//리소스를 불러오다가 에러가 발생했을 때 보여줄 이미지 일부러 주소 다르게 오류("https://reqres.in/img/faces/1image.jpg")
                .into(binding.glideImage)
        }


    }
}

class MyApplication:Application(){
    companion object{
        var retrofit: Retrofit
        var networkService: INetworkService
        init {
            retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            networkService = retrofit.create(INetworkService::class.java)
        }

    }
}