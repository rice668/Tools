package BasicAlgorithms.SortAndFind;

/**
 * Time of quick sort depends on the array is symmetric or not every time array's partition.
 */
public class QuickSortTest {
  // The key point to quicksort
  public int partition(int[] arr, int p, int r) {
    int x = arr[r];
    int i = p - 1;
    for (int j = p; j <= r - 1; j++) {
      if (arr[j] <= x) {
        i = i + 1;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    } // when jump to the for loop, j is equal to r
    int temp = arr[i + 1];
    arr[i + 1] = arr[r];
    arr[r] = temp;
    return i + 1;
  }

  public int[] quickSort(int[] arr, int p, int q) {
    if (p < q) {
      int povit = partition(arr, p, q);
      quickSort(arr, p, povit - 1);
      quickSort(arr, povit + 1, q);
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
    for (int i : new QuickSortTest().quickSort(arr, 0, arr.length - 1)) {
      System.out.println(i);
    }
  }
}
