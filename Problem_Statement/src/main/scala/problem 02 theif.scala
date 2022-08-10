object problem_theifdata_csvfileread extends App{
  import scala.annotation.tailrec
  import scala.math.Fractional.Implicits.infixFractionalOps

    val source = scala.io.Source.fromFile(this.getClass.getResource("thief_data.csv").toURI)
    val csvData = source.getLines
    val inputList = csvData
    inputList.foreach(x => {
      val y = if (x.head == '0') remote(x) + 1 else remote(x)
      println(y)
    })
    @tailrec
    def remote(x:String, count:Int=0 ):Int  = {
      if(x.length==1) count else if ( x.head == x(1)) remote( x.tail , count ) else remote(x.tail , count+1)


    }



}
