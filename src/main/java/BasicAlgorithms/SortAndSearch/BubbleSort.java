package BasicAlgorithms.SortAndSearch;

public class BubbleSort {

  static void bubble_sort(int[] list) {
    for (int i = 0; i < list.length; i++) {
      for (int j = i; j < list.length; j++) {
        if (list[i] > list[j]) {
          int temp = list[i];
          list[i] = list[j];
          list[j] = temp;
        }
      }
    }
  }
  public static void main(String[] args) {
    int[] arr = {5,1,2,8};
    bubble_sort(arr);
    System.out.println(arr[0]);
    String str = "123 ";
    System.out.println(str.trim().length());
  }
}
