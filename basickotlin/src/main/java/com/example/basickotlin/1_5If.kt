package com.example.basickotlin

//조건문
//if문
// 형태
// if(조건){수행문}else if(다른조건){수행문}else{수행문}
var data = 20
fun main() {
    //표현식 - 결과값을 반환하는 계산식
    var result = if (data > 20){
        "data는 20보다 크다."
    }else if(data < 20){
        "data는 20보다 작다."
    }else{
        "data는 20과 같다."
    }

    println(result)
}