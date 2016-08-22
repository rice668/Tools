package BasicAlgorithms.String

/**
  * Created by root on 16-8-10.
  */
object reverseStringByScala extends App {

  def reverseString(xs:String): String = {
    if (xs.length == 1) xs
    else reverseString(xs.tail)+xs.head
  }

  println(reverseString("12345"))

}
