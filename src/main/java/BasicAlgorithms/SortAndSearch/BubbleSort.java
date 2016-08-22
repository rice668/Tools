package BasicAlgorithms.SortAndSearch;

public class BubbleSort {

  static void bubble_sort(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {6, 2, 4, 1, 5, 9, -9, -3, -7, -7, 0};
    bubble_sort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
