package sort;

public class SelectionSort {


    public static void main(String[] args) {

        int[] input = {2, 7, 4, 1, 5, 3};

        new SelectionSort().selectionSort(input);

    }


    private void selectionSort(int[] input) {

        // Element to be compared
        for (int i = 0; i < input.length; i++) {

            int minIndex = i;

            // Element to be compared to
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap element at 0 (till end) with minIndex element
            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }

        System.out.println();
    }

}
