package BasicAlgorithms.SortAndSearch;

public class SelectionSort {

  public int[] selectionSort(int[] list) {
    // 需要遍历获得最小值的次数
    // 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
    for (int i = 0; i < list.length - 1; i++) {
      int temp;
      int index = i; // 用来保存最小值的索引
      // 寻找第i个小的数值
      for (int j = i + 1; j < list.length; j++) {
        if (list[index] > list[j]) {
          index = j;
        }
      }
      // 每次把选择到的最小的数字和第i次的值进行交换
      temp = list[index];
      list[index] = list[i]; // list[i]是关键，每次和这个交换
      list[i] = temp;
    }
    return list;
  }

  public static void main(String[] args) {
    int[] a = {2, 1, 4, 7, 5, 3, 6, 8};
    for (int i : new SelectionSort().selectionSort(a)) {
      System.out.print(i + " ");
    }
  }
}
