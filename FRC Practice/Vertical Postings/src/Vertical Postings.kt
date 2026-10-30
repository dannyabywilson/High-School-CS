fun main(){
    val UserIn = readln().toList()
    println(UserIn.joinToString(" "))

    for (i in 1 until UserIn.size){
        println(UserIn[i])
    }


}