object Problem_3_coredegitproblem extends App{
  def sum ( n: Int  , multiplyer : Int   ) : Int = {
    if (n < 10) n
    else sum(reducer(n, multiplyer), 1)
  }

  def reducer(n: Int, multiplier: Int): Int = {
    (n.toString * multiplier).toCharArray.map(x => x.toString).map(c => c.toInt).toList.sum

  }
  // Sample file with two number

   println( sum( 895469785, 56989 ))
   println(  sum ( 987546, 78321))

//  val n: Int = 9785
//  val multiplyer: Int = 4
//
////  val result = (n.toString * multiplyer).toCharArray.map(x => x.toString).map(c => c.toInt).toList.sum
//  val result = (n.toString * multiplyer).toCharArray.map(x => x.toString).map(c => c.toInt).toList
//
//
//  println("result: " + result)

  }



