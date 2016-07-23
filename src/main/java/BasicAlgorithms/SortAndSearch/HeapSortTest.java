package BasicAlgorithms.SortAndSearch;

/**
 * Main idea of Heap Sort.
 * <p/>
 * First Step: 【构建堆】[8, 7, 9, 14, 3, 2, 10, 4, 1, 16] ---> [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
 *             这一步的时间负责度为O(nlgn)，原因如下：每个元素都是在树中进行移动，因为树的高度是lgn,
 *             加上一共有堆大小个元素，所以是O(nlgn)
 * Second Step: 【维护堆】n不断的把堆顶元素和最后的元素进行交换，例如把16这个元素和1进行交换，放在正确的位置上
 *　　        　这一步的时间复杂度是O(lgn)，原因是下降是下降树的高度
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
