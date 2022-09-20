package com.example.basickotlin

//데이터 클래스 - 클래스 선언부 앞에 data키워드 붙여준다.
class NonDataClass(val name:String, val email:String)

data class DataClass(val name:String, val email:String)

//fun main() {
//    val non1 = NonDataClass("sik", "a@mail.com")
//    val non2 = NonDataClass("sik", "a@mail.com")
//
//    val data1 = DataClass("sik","a@mail.com")
//    val data2 = DataClass("sik","a@mail.com")
//
//    //equals비교
//    println("""
//        일반클래스 equals비교 : ${non1.equals(non2)}
//        data 클래스 equals비교 : ${data1.equals(data2)}
//    """.trimIndent())
//    //toString() -> 객체의 데이터를 반환
//    println("""
//        일반클래스 toString() : ${non1.toString()}
//        data 클래스 toString() : ${data1.toString()}
//    """.trimIndent())
//}

//오브젝트 클래스
open class Super3{
    open var data = 1
    open fun add(){
        println(1+1)
    }
}
//object:상위클래스 또는 인터페이스 를 명시해준다.
val obj = object:Super3() {
    override var data = 1
    override fun add(){
        println(1+1)
    }
}

//컴페니언 클래스
// 멤버변수나 함수를 클래스 이름으로 접근 하고자 할때 사용
class Companion{
    companion object{
        var compaData = 3
        fun some(){
            println(compaData)
        }
    }
}
fun main() {
    obj.data = 2
    obj.add()
    Companion.compaData
    Companion.some()
}