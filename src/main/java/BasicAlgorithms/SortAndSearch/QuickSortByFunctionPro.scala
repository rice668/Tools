package BasicAlgorithms.SortAndSearch

/**
  * Created by root on 16-8-9.
  */
object QuickSortByFunctionPro extends App {

  def quickSort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) xs
    else quickSort(xs.filter(x => x < xs.head)) ::: (xs.head) :: quickSort(xs.filter(x => x > xs.head))
  }

  print(quickSort(List(8,4,9,1,2,3)))

}

