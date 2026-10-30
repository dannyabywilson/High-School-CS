// Crazy Fencing
// first input is how many planks there are which tells how large array needs to be
// second input is the length of each plank
// third input is the width
// use ((a+b)/2)*h to calculate area of trapezoid
fun main() {
    val planks = readln().toInt()
    val lengths = readln().split(" ").map { it.toDouble()}

    val widths = readln().split(" ").map { it.toDouble() }

    var totalPaint = 0.0
    for (i in 0 until planks) {
        val paint = ((lengths[i] + lengths[i + 1]) / 2.0) * widths[i]
        totalPaint += paint
    }
    println(totalPaint)
}