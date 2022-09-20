package com.example.basickotlin

// 메인함수 실행 : ctrl + shift + F10 혹은 런버튼 아이콘 클릭
// 한줄주석 : ctrl + /
// 한줄삭제 : ctrl + y
// 한줄이동 : ctrl + shift + 화살표 위,아래

// 1. 변수
// 변수 선언 형식
// val (혹은 var) 변수명 : 타입 = 값

// var - 변수
var a:Int = 10
// val - 상수
val b:Int = 20

//초기화 미루기 : 변수선언후 초기화시 null로 선언할 필요가 없을때 사용
// 1. late init : 최상단,클래스내부에서 초기화를 미룰수 있다.(단, 기본타입은X)
lateinit var late:String //최상단에서 초기화 미루기
class variable{
    //클래스 내부에서 초기화 미루기
    lateinit var late2: String
}

//2. by lazy : 선언과 동시에 초기화를 해줌
// 호출시점에서 최초 1회 초기화가 된다.-> 호출시점에 초기화가 되기때문에 초기화미루기
val late2:Int by lazy{
    println("초기화 미루기2")
    10
}

// 메인함수
fun main(){
    late = "초기화 미루기 1번 입니다."
    a = 11
//    b = 12 -> 문법적 오류 발생
//    print("hello world")
//    println(late)
    println(late2)
    println(late2)
}