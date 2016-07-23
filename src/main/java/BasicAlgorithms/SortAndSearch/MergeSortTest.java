package BasicAlgorithms.SortAndSearch;

/**
 * 合并排序分治法三个步骤：
 * １．【分解】，将n个元素不断的分成n/2个元素的子序列
 * ２．【解决】，在n/2元素的子序列上继续递归的分解，也就是调用递归排序递归的分解
 * ３．【合并】，因为在分解的过程中【一直到不能分解停止】数据并没有什么规律，所以合并２个已经排序的子序列得到结果
 */
public class MergeSortTest {

  // merge the two array that is already sorted. One is a[p..q], another is a[q+1..r]
  public void merge(int a[], int p, int q, int r) {
    int n1 = (q - p) + 1;
    int n2 = (r - (q + 1)) + 1;
    int[] leftArr = new int[n1 + 1];
    int[] rightArr = new int[n2 + 1];
    for (int i = 0; i < n1; i++) {
      leftArr[i] = a[p + i];
    }
    for (int i = 0; i < n2; i++) {
      rightArr[i] = a[q + 1 + i];
    }
    leftArr[n1] = Integer.MAX_VALUE;
    rightArr[n2] = Integer.MAX_VALUE;
    int i = 0;
    int j = 0;
    for (int z = p; z < r + 1; z++) {
      if (leftArr[i] <= rightArr[j]) {
        a[z] = leftArr[i];
        i++;
      } else {
        a[z] = rightArr[j];
        j++;
      }
    }
  }

  public int[] mergeSort(int a[], int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(a, p, q);
      mergeSort(a, q + 1, r);
      merge(a, p, q, r);
    }
    return a;
  }

  public static void main(String[] args) {
    int[] arr = {3,5,1,7,2,4,1,9};
    for (int i : new MergeSortTest().mergeSort(arr, 0, arr.length - 1)) {
      System.out.println(i);
    }
  }
}
