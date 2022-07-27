import scala.io.StdIn

object Problem_1_usingrange extends App {


    (15000 to 25000).foreach(_ => {
      val line = StdIn.readLine().trim
      if (!line.isEmpty) {
        val arr = line.split(",", 3).map(_.trim).map(_.toInt)
        def student(K: Int, L: Int, M: Int) = {
          if (M >= L * K) {
            println("Yes")
          }
          else {
            println("No")
          }

        }
        student(arr(0), arr(1), arr(2))
      }
    })


}
