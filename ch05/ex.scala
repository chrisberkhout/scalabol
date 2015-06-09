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


class Person() {
  var theAge = 0;
  def age = theAge
  def age_=(givenAge: Int) : Unit = { theAge = 0.max(givenAge) }
}
var p = new Person()
p.age = -23
p.age

// 7



