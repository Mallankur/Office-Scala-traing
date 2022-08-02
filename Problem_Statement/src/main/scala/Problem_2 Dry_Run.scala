import scala.annotation.tailrec
import scala.math.Fractional.Implicits.infixFractionalOps

object Dry_Run extends App {
  val x = "01010111"
  val y = if(x.head=='0') remote(x)+1 else remote(x)
  @tailrec
  def remote(x:String, count:Int=0 ):Int  = {
    if(x.length==1) count else if ( x.head == x(1)) remote( x.tail , count ) else remote(x.tail , count+1)


  }

println(y)

}
