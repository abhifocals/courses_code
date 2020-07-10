package search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] input = {2, 10, 10, 10, 10, 18, 20};

        //int index = new BinarySearch.binarySearchIterative(input, 9);
        int index = new BinarySearch().binarySearchFirstOccurance(input, 10);

        System.out.println();
    }

    /*
    Binary Search Iteratively.
    */

    private int binarySearchIterative(int[] input, int elementToFind) {

        int low = 0;
        int high = input.length - 1;
        int mid = 0;

        while (low <= high) {

            mid = (low + high) / 2;

            if (elementToFind == input[mid]) {
                return mid;
            } else if (elementToFind < input[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /*
    Binary Search Recursively.
    */

    private int binarySearchRecursive(int[] input, int low, int high, int elementToFind) {

        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        } else if (elementToFind == input[mid]) {
            return mid;
        } else if (elementToFind < input[mid]) {
            return binarySearchRecursive(input, low, mid - 1, elementToFind);
        } else {
            return binarySearchRecursive(input, mid + 1, high, elementToFind);
        }
    }

    /*
    Binary Search Find First Occurance of an element.
    */
    private int binarySearchFirstOccurance(int[] input, int x) {

        int low = 0;
        int high = input.length - 1;
        int mid = 0;
        int result = -1;

        while (low <= high) {

            mid = (low + high) / 2;

            //  only these lines are different
            if (x == input[mid]) {
                result = mid;
                high = mid - 1;
            } else if (x < input[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

}
