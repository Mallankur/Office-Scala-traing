import Dry_Run.{x, y}

import java.util.jar.Attributes.Name
import scala.annotation.tailrec

object sum extends App {
  val source = scala.io.Source.fromFile("C:\\Personal\\Problem_1\\src\\main\\scala\\thief_data.csv")
  val csvData = source.getLines
  val inputList = csvData
  inputList.foreach(x => {
    val y = if (x.head == '0') remote(x) + 1 else remote(x)
  })

  def remote(x: String, count: Int = 0): Int = {
    if (x.length == 1) count else if (x.head == x(1)) remote(x.tail, count) else remote(x.tail, count + 1)


  }
  println(y)
}
