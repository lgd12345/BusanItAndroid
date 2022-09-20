package com.example.basickotlin

//조건문 - when문
// 특정 변수의 값에 따라 여러가지 흐름으로 제어가 가능
//형태
//when(변수){
//    조건1 -> 수행문
//    조건2 -> {
//        수행문
//    }
//    else -> {
//        수행문
//    }
//}

fun main() {
    var data2:Any = 20
//    when(data2){
//        "10" -> println("data는 10이다.")
//        "20" -> println("data는 20이다.")
//        else -> {
//            println("해당하는 값이 항목에 없음")
//        }
//    }

    //다양한 조건 활용
//    when(data2){
//        is String -> println("data2는 String타입이다.") //타입 확인 : is 타입
//        10,30 -> println("data2는 10또는 30이다.")
//        in 1..20 -> println("data2는 1부터 20사이의 값이다.") //범위 : in
//        else -> println("data2는 올바르지 않은 형식입니다.")
//    }

    //표현식
    var data3 = 10
    var result = when{
        data3 <= 0 -> "0은 data3보다 작거나 같다."
        data3 > 100 -> "data3은 100보다 크다."
        else -> "data3은 그외의 값이다."
    }
    println(result)
}