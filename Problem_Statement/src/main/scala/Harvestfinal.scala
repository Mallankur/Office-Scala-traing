import HarvestprobusingMap.{inputList1, inputList2}

import java.time.LocalDate

object Harvestfinal extends App {
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
    val monthly_best_gatherers= tupleList1.groupBy(x=>(x._2.getMonth,x._1)).map(x=>(x._1,x._2.map(_._4).sum))
      .groupBy(x=> x._1._1).map(x=> (x._1, x._2.maxBy(_._2) ))
    println(monthly_best_gatherers)
    val yearly_best_gatherer = tupleList1
      .groupBy(_._1).map(x => (x._1, x._2.map(_._4).sum)).maxBy(_._2)
    println(yearly_best_gatherer)
    val fruit_best_gatherers = tupleList1.groupBy(x => (x._3, x._1)).map(x => (x._1, x._2.map(_._4).sum))
      .groupBy(x => x._1._1).map(x => (x._1, (x._2.maxBy(_._2)._2, x._2.maxBy(_._2)._1._2)))
    println(fruit_best_gatherers)
    val multiplier2 = for {i <- tupleList1; j <- tupleList2 if (i._2 == j._2.minusDays(1) && i._3 == j._1)}
      yield (i._1, i._2.getMonth, i._3, i._4 * j._3) //(Gatherer, Month, Fruit, Selling)
    val monthly_best_earning_fruit=multiplier2
      .groupBy(x => (x._2, x._3)).map(x => (x._1, x._2.map(_._4).sum))
      .groupBy(x => x._1._1).map(x => (x._1, (x._2.maxBy(_._2)._2, x._2.maxBy(_._2)._1._2)))
    println(monthly_best_earning_fruit)
    val yearly_best_earning_fruit = multiplier2
      .groupBy(_._3).map(x => (x._1, x._2.map(_._4).sum)).maxBy(_._2)
    println(yearly_best_earning_fruit)
    val monthly_worst_earning_fruit = multiplier2
      .groupBy(x => (x._2, x._3)).map(x => (x._1, x._2.map(_._4).sum))
      .groupBy(x => x._1._1).map(x => (x._1, (x._2.minBy(_._2)._2, x._2.minBy(_._2)._1._2)))
    println(monthly_worst_earning_fruit)
    val yearly_worst_earning_fruit = multiplier2
      .groupBy(_._3).map(x => (x._1, x._2.map(_._4).sum)).minBy(_._2)
    println(yearly_worst_earning_fruit)
    val monthly_best_earning_person = multiplier2
      .groupBy(x => (x._2, x._1)).map(x => (x._1, x._2.map(_._4).sum))
      .groupBy(x => x._1._1).map(x => (x._1, (x._2.maxBy(_._2)._2, x._2.maxBy(_._2)._1._2)))
    println(monthly_best_earning_person)
    val yearly_best_earning_person = multiplier2
      .groupBy(_._1).map(x => (x._1, x._2.map(_._4).sum)).maxBy(_._2)
}
