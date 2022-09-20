package com.example.basickotlin

//컬렉션 타입
// 배열 - Array
// 같은 타입의 변수들로 이루어진 집합
// 배열을 구성하는 각각의 값을 배열요소(element)라고 하고,
// 배열에서의 위치를 가리키는 숫자는 인덱스(index)라고 한다.인덱스값은 0부터 시작

//배열생성 - 1.Array생성자 이용
//크기가 3인 배열을 생성하고, 각 값은 0으로 초기화
val array: Array<Int> = Array(3,{0})
//배열에 접근할때 - 대괄호[]를 이용하거나, set(), get() 함수를 이용한다.
//fun main(){
//    //배열에 값 할당
//    array[0] = 1
//    array[1] = 2
//    array.set(2,3)
//
//    //배열의 값을 확인
//    println("${array[0]} , ${array[1]}, ${array.get(2)}")
//    //배열의 크기확인
//    println(array.size)
//}

//배열 생성 2.기초타입의 배열생성
// 기초타입명+Array(배열의 크기, 초기값설정)
val boolArray:BooleanArray = BooleanArray(4,{false})
val charArray:CharArray = CharArray(2,{'a'})

//arrayOf - 배열생성 함수
//1.기초타입 배열 생성 - 기초타입명+arrayOf(엘레멘트 설정)
val intArray = intArrayOf(10,20,30,40)
val boolArray2 = booleanArrayOf(true,false,true)

//2. arrayOf(엘레멘트 설정)
val strArray = arrayOf("abc","de","fg")
val intArray3 = arrayOf(1,2,3)

//List, Set, Map
//List - 순서가 있다. 데이터 중복 허용
//Set - 순서가 없다. 데이터 중복 불가
//Map - key값 과 value값으로 이루어진 데이터 집합, 순서가 없고, key값은 중복 X

fun main() {
    //listOf - 불변
    var list = listOf<Int>(1,2,3)
//    list[0] = 4 -> listOf는 데이터 불변이기 때문에 문법에러 발생
    //mutableListOf - 가변
    var list2 = mutableListOf<Int>(1,2,3)
    list2[0] = 4
    list2.set(1,5)
    list2.add(3,6)
    println(list2.get(0) + list2[1])

    //mutableSetOf - 가변
    var set = mutableSetOf<Int>(5,6,7)
    set.add(5)//중복
    set.add(6)//중복
    set.add(8)
    println(set)

    //mutableMapOf - 가변
    var map = mutableMapOf<String,String>(Pair("first","1"), "second" to "2")
    map.put("three","3")//map에 새로운 키,벨류 추가
    println(map)
    //키값이 first,second에 해당하는 value값을 추출한다.
    println(map.get("first") + map.get("second"))
    println(map.keys)
}


