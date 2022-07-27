object Problem_3_using_Int extends App {

    def sum ( n: BigInt    ) : BigInt = {
      if( n<10) n
      else  n.toString.toCharArray.map(x => x.toString).map(c => c.toInt).toList.sum

    }

    def reducer(n: BigInt , n2: BigInt  ): BigInt = {
      (sum(sum(n)*n2))


    }
    println(reducer( 9785, 4))


}
