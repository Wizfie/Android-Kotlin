package data

class Boss(val name : String) {

   inner class Employee(val name: String){

        fun hi(){
            println("Hi, My name is $name , my Boss is ${this@Boss.name} ")
        }
    }
}