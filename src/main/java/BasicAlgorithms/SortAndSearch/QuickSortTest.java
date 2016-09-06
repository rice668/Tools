package BasicAlgorithms.SortAndSearch;

/**
 * Time of quick sort depends on the array is symmetric or not every time array's partition.
 * <p/>
 * 快速排序也是用了分治法解决问题
 * １．分解【将数组a[p...r]被划分成两个(可能空)的子数组a[p...q-1]＆a[q+1...r]，使得a[p...q-1]
 * 里面的元素都小于等于a[q]，而且小于等于a[q+1...r]的元素】,数组a[q+1...r]里面的元素都是大于等于a[q]，
 * 下标q也在这个过程中计算
 * ２．解决，递归的分解a[p...q-1]&a[q+1...r]两个子数组
 * ３．因为两个子数组存在关系，左边的永远小于等于右边的，当递归结束的时候，已经是有序的了，所以不需要合并
 * <p/>
 * 快速排序时间复杂度如下：
 * 最坏情况是每次划分都不对称，划分之后一边是一个，一边是n-1个，这种极端情况的时间复杂度就是O(n2).
 * T[n] = T[n-1] + T[1] + O(n) = O(n+(n-1)+(n-2) + ...+3+2+1) = O(n^2)
 * <p/>
 * 如果每次划分是比较对称的
 * T[n] = 2T[n/2] + O(n) 那么和合并排序时间复杂度是一样的
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

  // Good to make sense,找到pivot元素所在的最终位置
  public static int partitionByTiger(int array[], int low, int high) {
    int pivotKey = array[low];
    while (low < high) {
      while (low < high && array[high] >= pivotKey) {
        high--;
      }
      array[low] = array[high];
      while (low < high && array[low] <= pivotKey) {
        low++;
      }
      array[high] = array[low];
    }
    array[low] = pivotKey;
    return high;
  }

  public int[] partitionByQi(int[] array, int low, int high) {
    int pivot = array[low];
    while (low < high) {
      while (high > low && array[high] >= pivot) {
        high--;
      }
      swap(array, low, high);
      while (high > low && array[low] <= pivot) {
        low++;
      }
      swap(array, low, high);
    }
    return array;
  }

  public void swap(int[] array, int low, int high) {
    int temp;
    temp = array[high];
    array[high] = array[low];
    array[low] = temp;
  }

  public int[] quickSort(int[] arr, int p, int q) {
    if (p < q) {
      int pivot = partitionByTiger(arr, p, q);
      quickSort(arr, p, pivot - 1);
      quickSort(arr, pivot + 1, q);
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, -9, 18};
    for (int i : new QuickSortTest().partitionByQi(arr, 0, arr.length - 1)) {
      System.out.print(i + " ");
    }
  }
}
