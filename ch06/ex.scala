// 1

:paste
object Conversions {
  def inchesToCentimeters(inches: Double) = { inches * 2.54 }
  def gallonsToLiters(gallons: Double) = { gallons * 3.78541 }
  def milesToKilometers(miles: Double) = { miles * 1.60934 }
}

Conversions.inchesToCentimeters(3.0) - 7.62 < 0.01
Conversions.gallonsToLiters(3.0) - 11.36 < 0.01
Conversions.milesToKilometers(3.0) - 4.83 < 0.01

// 2

:paste
class UnitConversions
object InchesToCentimeters extends UnitConversions() { def doIt(input: Double) = { input * 2.54 } }
object GallonsToLiters extends UnitConversions() { def doIt(input: Double) = { input * 3.78541 } }
object MilesToKilometers extends UnitConversions() { def doIt(input: Double) = { input * 1.60934 } }

InchesToCentimeters.doIt(3.0) - 7.62 < 0.01
GallonsToLiters.doIt(3.0) - 11.36 < 0.01
MilesToKilometers.doIt(3.0) - 4.83 < 0.01

// with an abstract method
:paste
abstract class UnitConversions {
  def doIt(input: Double): Double
}
object InchesToCentimeters extends UnitConversions() { override def doIt(input: Double) = { input * 2.54 } }
object GallonsToLiters extends UnitConversions() { override def doIt(input: Double) = { input * 3.78541 } }
object MilesToKilometers extends UnitConversions() { override def doIt(input: Double) = { input * 1.60934 } }

InchesToCentimeters.doIt(3.0) - 7.62 < 0.01
GallonsToLiters.doIt(3.0) - 11.36 < 0.01
MilesToKilometers.doIt(3.0) - 4.83 < 0.01

// with a method in the superclass that has an implementation
:paste
class UnitConversions {
  def doIt(input: Double, factor: Double = 1.0) : Double = { input * factor }
}
object InchesToCentimeters extends UnitConversions() { def doIt(input: Double) = { super.doIt(input, 2.54) } }
object GallonsToLiters extends UnitConversions() { def doIt(input: Double) = { super.doIt(input, 3.78541) } }
object MilesToKilometers extends UnitConversions() { def doIt(input: Double) = { super.doIt(input, 1.60934) } }

(new UnitConversions).doIt(1.0) == 1.0
InchesToCentimeters.doIt(3.0) - 7.62 < 0.01
GallonsToLiters.doIt(3.0) - 11.36 < 0.01
MilesToKilometers.doIt(3.0) - 4.83 < 0.01

// 3

object Origin extends java.awt.Point // bad idea cos Point is mutable
Origin.move(2,3) // e.g.
Origin

// 4

:paste
class Point(var x: Int, var y: Int) {
  override def toString() = { f"($x,$y)" }
}
object Point {
  def apply(x: Int, y: Int) = { new Point(x,y) }
}

val p = Point(1,2)

// 6

object Suit extends Enumeration {
  val Clubs = Value("♣")
  val Diamonds = Value("♦")
  val Hearts = Value("♥")
  val Spades = Value("♠")
}
for (s <- Suit.values) println(s+f" (${s.id})")

// 7

def colorOf(suit: Suit.Value) =
  if (List(Suit.Diamonds, Suit.Hearts).contains(suit)) "red" else "black"
for (s <- Suit.values) println(f"$s (${s.id}, ${colorOf(s)})")

// 8

object RGBCubeCorner extends Enumeration {
  val Black   = Value(0x000000)
  val Blue    = Value(0x0000ff)
  val Red     = Value(0xff0000)
  val Magenta = Value(0xff00ff)
  val Green   = Value(0x00ff00)
  val Cyan    = Value(0x00ffff)
  val Yellow  = Value(0xffff00)
  val White   = Value(0xffffff)
}

