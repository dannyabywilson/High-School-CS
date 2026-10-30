fun main(){
    val sn = readln().toInt()

    val nums = mutableSetOf<Int>()

    for (n in 1..sn){
        nums.add(readln().toInt())
    }

    println(nums.size)

}