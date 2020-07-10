package sort;

public class InsertionSort {

    public static void main(String[] args) {

        int[] input = {7, 2, 4, 1};

        new InsertionSort().insertionSort(input);

    }


    private void insertionSort(int[] input) {

        for (int i = 0; i < input.length; i++) {

            int currentValue = input[i];
            int hole = i;

            while (hole > 0 && input[hole - 1] > currentValue) {

                input[hole] = input[hole - 1];
                hole = hole - 1;

            }
            input[hole] = currentValue;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

    }
}
