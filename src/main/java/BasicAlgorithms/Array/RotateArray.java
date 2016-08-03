package BasicAlgorithms.Array;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * O(1) space solution, O(n) time
     * Rotate is a good idea in solving these problems.
     */
    public static int[] rotateByLeecode(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        k = k % nums.length; // do not discard
        reverseArray(nums, 0, nums.length - k - 1);
        reverseArray(nums, nums.length-k, nums.length-1);
        reverseArray(nums, 0, nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
        for(Integer i : rotateByLeecode(new int[]{1,2}, 1)) {
            System.out.print(i);
        }

    }
}