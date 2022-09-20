package com.example.basickotlin

//반복문
fun main() {
    //for문
    // 기본형태
    // for(i in 범위){ 수행문 }
    // 1~10까지 출력
    for (i in 1..10){
        print(" "+i)
    }
    println()
    //1부터 9까지 1씩 증가(10은 미포함) until
    for(i in 1 until 10 ){
        print(" "+i)
    }
    println()
    //2부터 10까지 2씩 증가 step
    for(i in 2..10 step 2){
        print(" "+i)
    }
    println()
    //10부터 1까지 1씩 감소 downTo
    for (i in 10 downTo 1){
        print(" "+i)
    }
    println()

    //while문
    // 형태 : while(조건문){ 수행문 }

    //for문을 활용한 1부터10까지 누적합
    var x = 0
    var sum = 0 //누적합
//    for(i in 1..10){
//        sum += i
//    }
    // while문을 활용한 1부터 10까지 누적합
    while (x<10){
        ++x
        sum += x
    }
    println(sum)

    //indices 컬렉션 타입의 인덱스
    var col = arrayOf(1,2,3)
    for(i in col.indices){
        print(" ${col[i]}")
    }

    //withIndex() 인덱스 + 실제 데이터
    for ((index, value) in col.withIndex()){
        println("col.index : ${index} , col.value : ${value}")
    }
}