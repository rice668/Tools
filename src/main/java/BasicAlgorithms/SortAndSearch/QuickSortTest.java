package BasicAlgorithms.SortAndSearch;

/**
 * Time of quick sort depends on the array is symmetric or not every time array's partition.
 *
 * 快速排序也是用了分治法解决问题　
 * １．分解【将数组a[p...r]被划分成两个(可能空)的子数组a[p...q-1]＆a[q+1...r]，使得a[p...q-1]
 * 里面的元素都小于等于a[q]，而且小于等于a[q+1...r]的元素】，下标q也在这个过程中计算
 * ２．解决，递归的分解a[p...q-1]&a[q+1...r]两个子数组
 * ３．因为两个子数组存在关系，左边的永远小于等于右边的，当递归结束的时候，已经是有序的了，所以不需要合并
 */
public class QuickSortTest {
  // The key point to quick　sort
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
      int pivot = partition(arr, p, q);
      quickSort(arr, p, pivot - 1);
      quickSort(arr, pivot + 1, q);
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
