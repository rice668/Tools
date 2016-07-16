package BasicAlgorithms;

public class TransposeMatrix {
    public int[][] transMatrix(int[][] arr) {
        int[][] newArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[][] arr =
                {
                        {1, 2, 3, 4},
                        {4, 5, 6, 5},
                        {7, 8, 9, 10}
                };
        TransposeMatrix t = new TransposeMatrix();
        int[][] transMarr = t.transMatrix(arr);
        for (int i = 0; i < transMarr.length; i++) {
            for (int j = 0; j < transMarr[0].length; j++) {
                System.out.print(transMarr[i][j] + " ");
            }
            System.out.println();
        }
    }
}