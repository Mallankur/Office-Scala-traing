import scala.annotation.tailrec

object Problem_3usingStri extends App {
  @tailrec
  def reducer2(n: Int, multiplyer : Int   ) :Long = {
    if (n < 10) n
    else reducer2(reducer(n, multiplyer), 1)
  }

  def reducer(n: Int, multiplier: Int)= {
    (n.toString * multiplier).toCharArray.map(x => x.toString).map(c => c.toInt).toList.sum
  }

  println( reducer2( 9785, 4 ))
  // Sample
  println( reducer2( 100000, 10000 ))


}
