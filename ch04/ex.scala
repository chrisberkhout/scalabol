// 1

val gizmos = Map("Keyboard" -> 200.0, "Phone" -> 249.0)

(for ((i,p) <- gizmos) yield (i,p*0.9)).toMap

// 2

improt scala.collection.mutable

val in = new java.util.Scanner(new java.io.File("gatsby.txt"))
var words : mutable.Map[String, Int] = mutable.Map()
while (in.hasNext()) {
  val word = in.next().replaceAll("[^A-Za-z]", "").toLowerCase
  words(word) = words.getOrElse(word, 0) + 1
}
for ((word,n) <- words) println(f"$n%5d $word")

// 3

val in = new java.util.Scanner(new java.io.File("gatsby.txt"))
val words Map[String, Int] = Map()
while (in.hasNext()) {
  val word = in.next().replaceAll("[^A-Za-z]", "").toLowerCase
  val words = words + (word, words.getOrElse(word, 0) + 1)
}
for ((word,n) <- words) println(f"$n%5d $word")

// 4

import collection.immutable.SortedMap

val in = new java.util.Scanner(new java.io.File("gatsby.txt"))
var words : SortedMap[String, Int] = SortedMap()
while (in.hasNext()) {
  val word = in.next().replaceAll("[^A-Za-z]", "").toLowerCase
  words = words + ((word, words.getOrElse(word, 0) + 1))
}
for ((word,n) <- words) println(f"$n%5d $word")

// 5

import scala.collection.JavaConversions.mapAsScalaMap

val in = new java.util.Scanner(new java.io.File("gatsby.txt"))
var words: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
while (in.hasNext()) {
  val word = in.next().replaceAll("[^A-Za-z]", "").toLowerCase
  words(word) = words.getOrElse(word, 0) + 1
}
for ((word,n) <- words) println(f"$n%5d $word")

// 6

import collection.mutable.LinkedHashMap

var lhm : LinkedHashMap[String,Int] = LinkedHashMap()
lhm += ("Monday" -> java.util.Calendar.MONDAY)
lhm += ("Tuesday" -> java.util.Calendar.TUESDAY)
lhm += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
lhm += ("Thursday" -> java.util.Calendar.THURSDAY)
lhm += ("Friday" -> java.util.Calendar.FRIDAY)
lhm += ("Saturday" -> java.util.Calendar.SATURDAY)
lhm += ("Sunday" -> java.util.Calendar.SUNDAY)
for ((k,v) <- lhm) println(f"$v%3d $k")

// 7

val keyLengths = for ((k,v) <- System.getProperties()) yield k.toString.length
val maxWidth = keyLengths.max
for ((k,v) <- System.getProperties()) {
  print(s"%-${maxWidth}s" format k)
  print(" | ")
  println(v)
}

// 8

def minmax(values: Array[Int]) = (values.min, values.max)
minmax(Array(1,3,5,2,2,56,6,6,3,12,12,2,-2))

// 9

def lteqgt(values: Array[Int], v: Int) = {(
  values.filter(_ < v).length,
  values.filter(_ == v).length,
  values.filter(_ > v).length
)}
lteqgt(Array(1,3,5,2,2,56,6,6,3,12,12,2,-2), 6)

// 10

"Hello".zip("World")


