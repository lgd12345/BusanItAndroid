package com.example.ex10_networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface INetworkService {
    @GET("api/users")
    fun doGetUserList(
        @Query("page") page: String
    ): Call<UserListModel>
    //최종 url 형태 : https://reqres.in/api/users?page=1

    @GET("api/users/{id}")
    fun test2(
        @Path("id") userId:Int
    ):Call<ResponseData>
    //최종 url 형태 : https://reqres.in/api/users/{id}

    @GET("group/users")
    fun test3(
        @QueryMap options:Map<String,String>,
        @Query("name") name:String
    ):Call<UserModel>
    //최종 url 형태 : https://reqres.in/group/users?name=sik&one=안드로이드&two=스튜디오
    //or
    //최종 url 형태 : https://reqres.in/group/users?one=안드로이드&two=스튜디오&name=sik
    //or ...
}