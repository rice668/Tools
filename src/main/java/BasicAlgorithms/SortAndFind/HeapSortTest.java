package BasicAlgorithms.SortAndFind;

/**
 * Main idea of Heap Sort.
 * <p/>
 * First Step: [8, 7, 9, 14, 3, 2, 10, 4, 1, 16] ---> [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
 * Second Step: 不断的把堆顶元素和最后的元素进行交换，例如把16这个元素和1进行交换，放在正确的位置上
 * Third Step: 重复Second Step
 */
public class HeapSortTest {

  void maxHeapify(int[] a, int i) {
  }

  void buildMaxHeap(int[] a) {
  }

  void swap(int a, int b) {
  }

  void HeapSort(int[] a) {
    buildMaxHeap(a);
    int heapSize = a.length;
    for (int i = a.length; i >= 2; i--) {
      swap(a[i], a[0]);
      heapSize = heapSize - 1;
      maxHeapify(a, 1);
    }
  }

  public static void main(String[] args) {

  }
}
