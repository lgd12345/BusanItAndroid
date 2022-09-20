package com.example.basickotlin

// 상속 -
// 부모클래스 -> open키워드 사용
// 자식클래스 -> 변수에 타입을 지정하듯이 클래스명 + :부모클래스 를 명시해준다.
open class Super(name:String){
    init {
        println("부모 클래스 생성")
    }
}
class Sub(name:String):Super(name){
    init {
        println("자식 클래스 생성")
    }
}
//자식클래스에 보조 생성자만 있는경우
class Sub2:Super{
    constructor(name:String):super(name){
        println("자식 클래스 생성2")
    }
}
//오버라이딩 (재정의)
open class Super2{
    //변수에 open키워드를 이용하여 작성해야 자식클래스에서 오버라이드 받을수 있다.
    open var superData = 10
    open fun testFun(){
        println("부모클래스의 함수 호출 : ${superData}")
    }
}
class Sub3:Super2(){
//    override var superData = 20 ->부모클래스의 멤버가 open 상태가 아니라서 에러
    //override 키워드를 이용하여 부모클래스의 멤버(변수,함수)를 재정의
    override var superData = 20
    override fun testFun() {
        println("자식 클래스의 함수 호출 : ${superData}")
    }
}
//fun main() {
////    val sub = Sub("sik")
////    val sub2 = Sub2("sik2")
//    val sub3 = Sub3()
//    println(sub3.superData)
//    sub3.testFun()
//}

//접근제한자
// public, internal, protected, private
// 최상단에서 선언할경우
public var pub = 1 //모든 파일에서 접근이 가능(public키워드 생략가능)
internal var inter = 2 //같은 모듈내에서 접근이 가능
private var pri = 3 //해당 파일내부에서만 접근이 가능
//protected var pro = 4 -> 최상단에서 작성 안됨

//class Public{
//    //클래스 내부에서 선언한경우
//    public var pub2 = 1 //모든 클래스에서 사용가능
//    internal var inter2 = 2 //같은 모듈내에서 접근 가능
//    private var pri2 = 3 //클래스 내부에서만 이용가능
//    protected var pro = 4 // 상속관계의 하위(자식)클래스 에서만 사용가능
//}

open class Public{
    //클래스 내부에서 선언한경우
    open public var pub2 = 1 //모든 클래스에서 사용가능
    open internal var inter2 = 2 //같은 모듈내에서 접근 가능
    private var pri2 = 3 //클래스 내부에서만 이용가능 , 상속이 안됨.
    open protected var pro = 4 // 상속관계의 하위(자식)클래스 에서만 사용가능
}

class Child:Public(){
    override var pub2 = 5
    override var inter2 = 6
    override var pro = 7
}

fun main() {
    var child = Child()
    child.inter2
    child.pub2
//    child.pro
}