import scala.io.StdIn

object Problem_1 extends App {
    object problemstatement1 extends App{
      val source = scala.io.Source.fromFile("C:\\Personal\\Scala\\Office-Scala-traing\\Problem_Statement\\src\\main\\scala")
      val csvData = source.getLines

      def student(K: Int, L: Int, M: Int) = if (M >= L * K) println("Yes") else println("No")

      csvData.foreach(line =>
        if (line.nonEmpty){
          val arr = line.split(",").map(_.toInt)
          (student(arr(0),arr (1), arr(2)))
        })

    }

}

