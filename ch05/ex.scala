// 1

class Counter {
  private var value = 0 // You must initialize the field
  def increment() { value += 1 } // Methods are public by default
  def current() = value
}
var counter = new Counter()
for (i <- 1 to Int.MaxValue) counter.increment()
counter.increment()
counter.current()

class Counter {
  private var value : Long = 0 // You must initialize the field
  def increment() { value += 1 } // Methods are public by default
  def current() = value
}
var counter = new Counter()
for (i <- 1 to Int.MaxValue) counter.increment()
counter.increment()
counter.current()

// 2

class BankAccount {
  private var privBalance : Long = 0
  def balance = privBalance
  def deposit(n: Long) = { privBalance += n; privBalance }
  def withdraw(n: Long) = { privBalance -= n; privBalance }
}
var ba = new BankAccount()
ba.balance
ba.deposit(20)
ba.deposit(30)
ba.withdraw(25)

// 3

class Time(val hours: Int, val minutes: Int) {
  if (hours < 0 || hours > 23) throw new IllegalArgumentException("bad hour")
  if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("bad minute")
  override def toString() = f"${hours}%02d:${minutes}%02d"
  def before(other: Time) = hours <= other.hours && minutes <= other.minutes
}
val t = new Time(23,6)
t.before(new Time(23,16))
t.before(new Time(22,3))

new Time(24,0)
new Time(22,-1)

// 4

class Time(givenHours: Int, givenMinutes: Int) {
  private val time = givenHours*60 + givenMinutes
  if (time < 0 || time >= 24*60) throw new IllegalArgumentException("time")
  def hours : Int = time / 60
  def minutes : Int = time % 60
  override def toString() = { f"${hours}%02d:${minutes}%02d" }
  def before(other: Time) = hours <= other.hours && minutes <= other.minutes
}

val t = new Time(23,6)
t.before(new Time(23,16))
t.before(new Time(22,3))

// 6

class Person(givenAge: Int) {
  val age = 0.max(givenAge)
}
val p = new Person(-23)
p.age


class Person {
  var theAge = 0;
  def age = theAge
  def age_=(givenAge: Int) : Unit = { theAge = 0.max(givenAge) }
}
var p = new Person
p.age = -23
p.age

// 7

class Person(name: String) {
  val Array(firstName, lastName) = name.split(" +")
  // val firstName :: lastName :: _ = name.split(" +").toList
}
val p = new Person("Mr Foo")
p.firstName
p.lastName

// 8

class Car(
  val manufacturer: String,
  val modelName: String,
  val modelYear: Int,
  var licensePlate: String
) {
  def this(manufacturer: String, modelName: String) {
    this(manufacturer, modelName, -1, "")
  }
  def this(manufacturer: String, modelName: String, modelYear: Int) {
    this(manufacturer, modelName, modelYear, "")
  }
  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName, -1, licensePlate)
  }
  override def toString() = f"'$manufacturer', '$modelName', '$modelYear', '$licensePlate'"
}
val c1 = new Car("Ford", "Alpacha", 1968, "MEE-333")
val c2 = new Car("Ford", "Bronco")
val c3 = new Car("Ford", "Bronco", 1968)
val c4 = new Car("Ford", "Bronco", "MEE-333")

class Car(
  val manufacturer: String,
  val modelName: String,
  val modelYear: Int = -1,
  var licensePlate: String = ""
) {
  override def toString() = f"'$manufacturer', '$modelName', '$modelYear', '$licensePlate'"
}
val c1 = new Car("Ford", "Alpacha", 1968, "MEE-333")
val c2 = new Car("Ford", "Bronco")
val c3 = new Car("Ford", "Bronco", 1968)
val c4 = new Car("Ford", "Bronco", licensePlate = "MEE-333")

// 9 - in Ruby - 2 or 3 lines longer, not as much flexibility in constructor invocation options, no type validation

class Car
  def initialize(manufacturer, modelName, modelYear: -1, licensePlate: "")
    @manufacturer = manufacturer
    @modelName = modelName
    @modelYear = modelYear
    @licensePlate = licensePlate
  end
  attr_reader :manufacturer, :modelName, :modelYear
  attr_accessor :licensePlate
end
c0 = Car.new("Ford", "Alpacha", 1968, "MEE-333") rescue 'broken'
c1 = Car.new("Ford", "Alpacha", modelYear: 1968, licensePlate: "MEE-333")
c2 = Car.new("Ford", "Bronco")
c3 = Car.new("Ford", "Bronco", modelYear: 1968)
c4 = Car.new("Ford", "Bronco", licensePlate: "MEE-333")

// 10

class Employee(val name: String, var salary: Double) {
  def this() { this("John Q. Public", 0.0) }
}

:paste
class Employee(name: String, salary: Double) {
  val theName: String = name
  var theSalary: Double = salary
  def this() { this("John Q. Public", 0.0) }
}


:paste
class Employee(val name: String = "John Q. Public", var salary: Double = 0.0)


val e1 = new Employee()

