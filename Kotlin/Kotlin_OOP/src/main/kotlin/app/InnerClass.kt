package app

import data.Boss

fun main(){

    val boss1 = Boss("Wizfi")

    val employee1 = boss1.Employee("Ikbal")
    val employee2 = boss1.Employee("Bayu")
    val employee3 = boss1.Employee("Lala")
    val employee4 = boss1.Employee("Esa ")

    println(employee1.hi())
    println(employee2.hi())
    println(employee3.hi())
    println(employee4.hi())

}