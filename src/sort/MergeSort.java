package sort;

public class MergeSort {

    public static void main(String[] args) {

        int[] input = {7, 2, 4, 1};

        new MergeSort().mergeSort(input);

    }


    private void mergeSort(int[] input) {

        // base condition
        if (input.length < 2) {
            return;
        }

        // Create Left and Right Arrays
        int mid = input.length / 2;
        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = input[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = input[i + mid];
        }

        // mergeSort left array
        mergeSort(left);

        // mergeSort right array
        mergeSort(right);

        // combine left and right array
        combineLeftRight(left, right, input);


        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        }
    }

    private void combineLeftRight(int[] left, int[] right, int[] input) {

        int i = 0;
        int j = 0;
        int k = 0;

        // while left and right arrays are not empty, pick least element among them
        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            } else {
                input[k] = right[j];
                j++;
            }
            k++;
        }

        // pick any leftovers from left or right [only 1 will have leftovers]
        while (i < left.length) {
            input[k] = left[i];
            i++;
        }

        while (i < right.length) {
            input[k] = right[j];
            j++;
        }
    }

}
