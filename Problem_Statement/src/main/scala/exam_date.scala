import scala.io.StdIn.readLine
object exam_date extends App{

  var str=" "
  while(str!= "") {
    str = readLine().filter(_ != ' ')
    if (str != "") {
      val x = str.split(",").map(_.toInt)
      def student(K: Int, L: Int, M: Int) = {
        if (M >= L * K) {
          println("Yes")
        }
        else {
          println("No")
        }

      }

      student(x(0), x(1), x(2));
    }
  }



}
