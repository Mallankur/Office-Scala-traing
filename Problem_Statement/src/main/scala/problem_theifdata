object problem_theifdata_csvfileread extends App{
  val source = scala.io.Source.fromFile("C:\\Personal\\Problem_1\\src\\main\\scala\\thief_data.csv")
  val csvData = source.getLines.toList
  val inputList= csvData.map(x=>convertStrToIntArr(x))
  inputList.foreach(processLine)

  def processLine(doorList: List[Int])= {
    def enterInDoor(doorList: List[Int], doorOpenCount: Int): Int = {
      if (doorList.isEmpty) doorOpenCount
      else if (doorList(0) == 1) enterInDoor(doorList.tail, doorOpenCount)
      else enterInDoor(doorList.tail.map(x => (x + 1) % 2), doorOpenCount + 1)
    }
    println(enterInDoor(doorList, 0))
  }

  def convertStrToIntArr(str: String): List[Int] = {
    var result: List[Int] = List()
    str.map(c => result = c.toString.toInt :: result)
    result
  }

}
