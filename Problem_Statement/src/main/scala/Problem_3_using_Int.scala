object Problem_3_using_Int extends App {

    def sum ( n: Long     ) : Long = {
      if( n<10) n
      else  n.toString.toCharArray.map(x => x.toString).map(c => c.toInt).toList.sum

    }

    def reducer(n: Long  , n2: Long  ) = {
      (sum(sum(n)*n2))


    }
    println(reducer( 978555, 4))


}
