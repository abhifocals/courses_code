package sort;

public class BubbleSort {


    public static void main(String[] args) {

        int[] input = {7, 2, 4, 1};

        new BubbleSort().bubbleSort(input);

    }


    private void bubbleSort(int[] input) {

        // Run below loop < n-1 times (n-1 is last element, no need to run it for that element)
        for (int k = 0; k < input.length-1; k++) {

            // Compare each element with next element and swap if i > i+1 value
            for (int i = 0; i < input.length-1; i++) {
                if (input[i] > input[i + 1]) {
                    swap(input, i, i+1);
                }
            }
        }

        System.out.println();
    }


    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];

        array[index1] = array[index2];
        array[index2] = temp;
    }
}
