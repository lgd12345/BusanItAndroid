package com.example.basickotlin

//문자열
// String 삼중따옴표 : 여러줄을 표현할때 사용
var str:String = """
    안녕하세요
    안드로이드 스튜디오입니다.
    오늘은 9월 16일 입니다.
""".trimIndent()

//fun main() {
//    //문자열 템플릿 -> 문자열 안에서 변수를 그대로 사용 가능
//    // 형태 : $변수명 or ${변수명}
//    println("삼중따옴표 : ${str}")
//}

//any - 모든 타입이 가능
var any:Any = 10
var any2:Any = "any"
var any3:Any = true

class any4
var any5:Any = any4()

//Unit - 반환문이 없는 함수의 타입
fun unit():Unit{
    println("unit 타입 명시")
}

fun unit2(){
     println("unit 타입 생략")
}

//Nothing - 함수에서 null이나 예외를 리턴 하는 타입
//의도적으로 에러를 발생시킬때 사용
fun fail():Nothing{
    throw IllegalAccessException("에러 발생")
}

fun fail2():Nothing?{
    return null
}

// null 허용 과 불허용
// 변수나 함수의 리턴값을 null로 받을수 있다.
// 타입뒤에 ?를 붙인다.
var num:Int = 10
var num2:Int? = 10

//엘비스 연산자 ?:
val elvis:String? = null
val elvisLengthIf = if(elvis != null) elvis.length else 0
val elvisLength = elvis?.length ?: 0

fun main() {
//    num = null -> null 불허용
    num2 = null
//    fail()
    println("elvisLengthIf : ${elvisLengthIf}")
    println("elvisLength : ${elvisLength}")
}