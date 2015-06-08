
// 1

:paste
def signum(num: Double): Int = {
  if (num > 0) 1
  else if (num < 0) -1
  else 0
}


// 4
// for (int i = 10; i >= 0; i--) System.out.println(i);

for (i <- 10 to 0 by -1) println(i)

// 5

def countdown(n: Int) = {
  for (i <- n to 0 by -1) println(i)
}

// 6

var r: Long = 1
for (c <- "Hello") r *= c.toInt
r

// 7

"Hello".foldLeft(1:Long)((a:Long,b) => a*b.toInt)

// 8

def product(s : String): Long = s.foldLeft(1:Long)((a:Long,b) => a*b.toInt)
product("Hello")

// 9

def productr(s : String): Long = {
  try {
    s(0).toInt * productr(s.drop(1))
  } catch {
    case _: java.lang.StringIndexOutOfBoundsException => 1
  }
}
productr("Hello")
productr("") // returns 1... not ideal

:paste
def productr(s : String): Long = {
  if (s.isEmpty) 0
  else s(0).toInt * productr(s.drop(1)).max(1)
}

productr("Hello")
productr("") // return 0... better

// 10

:paste
import math.{pow,abs}
def xn(x:Int,n:Int): Double = {
  if (n == 0) 1
  else if (n < 0) 1 / pow(x, abs(n))
  else if (n % 2 == 0) pow(pow(x, n/2), 2)
  else x * xn(x, n-1)
}


xn(2,0)
xn(2,-2)
xn(2,2)
xn(2,3)

