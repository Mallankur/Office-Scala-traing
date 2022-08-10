import Harvest_Dry.{earnFruit, tupleList1, tupleList2}
import Harvestfinal.multiplier2

import java.time.LocalDate

object HarvestprobusingMap extends App {
  val source1 = scala.io.Source.fromFile(this.getClass.getResource("harvest.csv").toURI)
  val Source2 = scala.io.Source.fromFile(this.getClass.getResource("prices.csv").toURI)

  val csvData1 = source1.getLines()
  val csvData2 = Source2.getLines()

  val inputList1 = csvData1.toList
  val inputList2=  csvData2.toList

    //println(LocalDate.parse("2020-01-31").getMonth)

    val tupleList1 = inputList1.map(line => line.trim.split(",")).map(x => (x(0), x(1), x(2), x(3))).drop(1)
      .map(x => (x._1, LocalDate.parse(x._2), x._3, x._4.trim.toDouble))
    val tupleList2= inputList2.map(x=>x.trim.split(",")).map(x=>(x(0),x(1),x(2))).drop(1)
      .map(x=>(x._1,LocalDate.parse(x._2),x._3.trim.toDouble))
    val  Multiplier1 =  for{ i <- tupleList1 ;   j <-tupleList2 if( i._2 == j._2.minusDays(1) && i._3 == j._1 )} // List( fruit,month, seller )
                      yield (j._1, j._2.getMonth, i._4*j._3)
   val  Multiplier2 =  for{ i <- tupleList1 ;   j <-tupleList2 if( i._2 == j._2.minusDays(1) && i._3 == j._1 )}
                   yield (i._1, i._2.getMonth, i._3, i._4)
  val  Multiplier3 =  for{ i <- tupleList1 ;   j <-tupleList2 if( i._2 == j._2.minusDays(1) && i._3 == j._1 )}
                      yield (i._1, i._2.getMonth, i._3, i._4*j._3)

  //solution
    val  MonthlyProfitablefruit= Multiplier1.groupBy(x=>x._2) // Map( Month , List( fruit,month, seller)
      .map(y=>(y._1,y._2.groupBy(x=>x._1))).map(z=>(z._1, z._2.map(n=>(n._1,n._2.map(_._3).sum)).maxBy(_._2))) // Map( Month, hashMap( fruit, List( fruit , month , seller ))
      println(MonthlyProfitablefruit) //
  val  yearlyProfitablefruit= Multiplier1.groupBy(x=>x._1) // Map( fruit , List( fruit,month, seller)
             .map(y=>(y._1,y._2.map(z=>z._3).sum)).maxBy(_._2)
        println(yearlyProfitablefruit)
  val  Monthlywrostfruit= Multiplier1.groupBy(x=>x._2) // Map( Month , List( fruit,month, seller)
    .map(y=>(y._1,y._2.groupBy(x=>x._1))).map(z=>(z._1, z._2.map(n=>(n._1,n._2.map(_._3).sum)).minBy(_._2))) // Map( Month, hashMap( fruit, List( fruit , month , seller ))
  println(Monthlywrostfruit) //
  val  yearlywrostfruit= Multiplier1.groupBy(x=>x._1) // Map( fruit , List( fruit,month, seller)
    .map(y=>(y._1,y._2.map(z=>z._3).sum)).minBy(_._2)
  println(yearlywrostfruit)

    //.map(y=>(y._1,y._2.groupBy(x=>x._1))).map(z=>(z._1, z._2.map(n=>(n._1,n._2.map(_._3).sum)).maxBy(_._2)))
  // Map( Month, hashMap( fruit, List( fruit , month , seller ))
  val monthly_best_gatherers= Multiplier2.groupBy(x=>x._2) // Map( Month , List( gerther,fruit,month, seller)
    .map(y=>(y._1,y._2.groupBy(x=>x._1)))//Map( Month gather), List( gerther,fruit,month, seller)
    .map(z=>(z._1, z._2.map(n=>(n._1,n._2.map(_._4).sum)).maxBy(_._2)))
  println(monthly_best_gatherers)
  val yearly_best_gatherers = Multiplier2.groupBy(x=>x._1)//Map(  gather), List( gerther,fruit,month, seller)
    .map(y=>(y._1,y._2.map(z=>z._4).sum)).maxBy(x=>x._2)
  println(yearly_best_gatherers)
  val monthly_best_earning_person = Multiplier3.groupBy(x=>x._2) // Map( Month , List(gethere ,fruit,month, seller)
    .map(y=>(y._1,y._2.groupBy(x=>x._1))).map(z=>(z._1, z._2.map(n=>(n._1,n._2.map(_._4).sum)).maxBy(_._2))) // Map( Month, hashMap( fruit, List( fruit , month , seller ))
  println(monthly_best_earning_person)
  val yearly_best_earning_person = Multiplier3
    .groupBy(_._1).map(x => (x._1, x._2.map(_._4).sum)).maxBy(_._2)
  println(yearly_best_earning_person)




}
