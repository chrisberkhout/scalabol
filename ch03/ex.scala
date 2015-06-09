
// 1

val r = new util.Random
val n = 10
val a = (for (i <- 0 until n) yield r.nextInt(n)).toArray

// 2

:paste
var a = Array(1,2,3,4,5)
for (i <- 0 until a.length if i % 2 == 1) {
  val other = a(i-1)
  a(i-1) = a(i)
  a(i) = other
}


// 3

:paste
var a = Array(1,2,3,4,5)
for (i <- 0 until a.length) yield {
  if (i % 2 == 0)
    if (i+1 < a.length) a(i+1)
    else a(i)
  else a(i-1)
}


// 4

:paste
var a = Array(-1,6,-3,4,0,5,-2)
Array.concat(a.filter(_ > 0), a.filter(_ <= 0))


// 5

var a = Array(4.0,6.0)
a.reduceLeft(_+_) / a.length

var a = Array(4.0,6.0)
a.sum / a.length

// 6

var a = Array(-1,6,-3,4,0,5,-2)
a.sortWith((a,b) => a>b)

var ab = collection.mutable.ArrayBuffer(-1,6,-3,4,0,5,-2)
ab.sortWith((a,b) => a>b)

// 7

Array(-1,6,-3,6,4,0,5,-2).toSet.toArray

// 8

// var first = true
// var n = a.length
// var i = 0
// while (i < n) {
//   if (a(i) >= 0) i += 1
//   else {
//     if (first) { first = false; i += 1 }
//     else { a.remove(i); n -= 1 }
//   }
// }

// var first = true
// val indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
//   if (a(i) < 0) first = false; i
// }
// for (j <- 0 until indexes.length) a(j) = a(indexes(j))
// a.trimEnd(a.length - indexes.length)

val a = collection.mutable.ArrayBuffer(-1,6,-3,6,4,0,5,-2)
val negIndexes = for (i <- 0 until a.length if a(i) < 0) yield i
for (i <- negIndexes.reverse.dropRight(1)) a.remove(i)
a

val a = collection.mutable.ArrayBuffer(-1,6,-3,6,4,0,5,-2)
for (i <- (0 until a.length).filter(a(_) < 0).drop(1).reverse) a.remove(i)
a

val a = collection.mutable.ArrayBuffer(-1,6,-3,6,4,0,5,-2)
val indexesToRemove = (0 until a.length).filter(a(_) < 0).drop(1)
for (i <- indexesToRemove.reverse) a.remove(i)
a

// 9

val amiPrefix = "America/"
val amiZones = java.util.TimeZone.getAvailableIDs.filter(_.indexOfSlice(amiPrefix) == 0)
val unprefixedAmiZones = amiZones.map(_.drop(amiPrefix.length))
unprefixedAmiZones.sortWith(_<_)

// 10

import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
val list = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
val ab : Buffer[String] = list

