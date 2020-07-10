package sort;

public class QuickSort {

    public static void main(String[] args) {

        int[] input = {2, 7, 4, 1, 5, 3};

        QuickSort qs = new QuickSort();

        qs.quickSort(input, 0, input.length - 1);

        qs.printOutput(input);

    }


    private void quickSort(int[] input, int start, int end) {

        if (start < end) {
            int pIndex = partition(input, start, end);

            quickSort(input, start, pIndex - 1);
            quickSort(input, pIndex+1, end);
        }
    }

    private int partition(int[] input, int start, int end) {

        // Assume a pIndex and pivot
        int pIndex = start;
        int pivotIndex = end;
        int pivot = input[pivotIndex];

        for (int i = start; i <= end-1; i++) {

            if (input[i] <= pivot) {
                swap(input, i, pIndex);
                pIndex++;
            }
        }

        swap(input, pIndex, pivotIndex);

        return pIndex;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];

        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void printOutput(int[] input) {

        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        }

    }

}


