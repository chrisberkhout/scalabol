
// 1

val r = new util.Random
val n = 10
val a = (for (i <- 0 until n) yield r.nextInt(n)).toArray

// 2

:paste
var a = Array(1,2,3,4,5)
for (i <- 0 until a.length; if i % 2 == 1) {
  val other = a(i-1)
  a(i-1) = a(i)
  a(i) = other
}


// 3


