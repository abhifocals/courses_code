package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Array {

    ArrayList<Integer> sortedList = new ArrayList<>();
    ArrayList<Integer> unsortedList = new ArrayList<>();


    public static void main(String[] args) {

//    new Array().sortedSquares(new int[] {-4,-1,0,3,10});

//        new Array().relativeSortArray(new int[]{1,5,1,4,2}, new int[] {1,2});

//        new Array().sortArrayByParity(new int[]{1,2,3,4,5});

//        new Array().rotate(new int[]{1,2,3,4,5,6,7},  3);

        new Array().intersection(new int[]{1,2}, new int[]{3,2,2});
    }









    // 5:349

    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> output =  new ArrayList<>();

            for (int i=0; i < nums1.length; i++) {

                for (int j=0; j < nums2.length; j++) {

                    if (nums1[i] == nums2[j] && !output.contains(nums1[i])) {
                        output.add(nums1[i]);
                    }
                }
            }

            int[] outputArray = new  int[output.size()];

            for (int i=0; i < output.size(); i++) {
                outputArray[i] = output.get(i);
            }

        return outputArray;
    }



























    // 4:189
    public void rotate(int[] nums, int k) {

        for (int j = 0; j < k; j++) {

            int[] newNums = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

                if (i == nums.length - 1) {
                    newNums[0] = nums[nums.length - 1];
                } else {
                    newNums[i + 1] = nums[i];
                }
            }

            for (int i=0; i < newNums.length; i++) {
                nums[i] = newNums[i];
            }
        }
    }


    // 3:905
    public int[] sortArrayByParity(int[] A) {

        ArrayList<Integer> combined = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        int[] output = new int[A.length];
        int outputIndex = 0;


        // value mod 2 == null? add to even list, else add to odd list
        for (int i=0; i<A.length; i++) {
            if (A[i] % 2 == 0) {
                output[outputIndex] = A[i];
                outputIndex ++;
            }
            else {
                odds.add(A[i]);
            }
        }

        for (int i=0; i < odds.size(); i++) {

            int startingIndex = A.length - odds.size();

            output[startingIndex+i] = odds.get(i);

        }

            System.out.println();


        return output;
    }





























    // 2:1122
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // (Value, Index)
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // (Group#, List)
        HashMap<Integer, ArrayList<Integer>> groupMap = new HashMap<>();

        int[] output = new int[arr1.length];
        ArrayList<Integer> values = null;
        ArrayList<Integer> orphans = new ArrayList<>();
        ArrayList<Integer> outputList = new ArrayList<>();

        for (int i=0; i<arr2.length; i++) {
            indexMap.put(arr2[i], i);
        }


        // Find item in hashmap.  That's the group #.
        for (int i = 0; i < arr1.length; i++) {
            int group = -1;

            // assign group for placement
            if (indexMap.get(arr1[i]) != null) {
                group = indexMap.get(arr1[i]);
            }

            // get the list for index and add to it
            if (group >= 0 && groupMap.get(group) != null) {
                values = groupMap.get(group);
                values.add(arr1[i]);
            }

            // if group not already in groupMap, add to it
            else if (group >= 0) {
                values = new ArrayList<>();
                values.add(arr1[i]);
                groupMap.put(group, values);
            }

            // this is the list not in array2
            else {
                    orphans.add(arr1[i]);
            }
        }


        for (int i: groupMap.keySet()) {

            for (int j=0; j < groupMap.get(i).size(); j++) {
                outputList.add(groupMap.get(i).get(j));
            }
        }


        Collections.sort(orphans);

        for (int i=0; i<orphans.size(); i++) {
            outputList.add(orphans.get(i));
        }


        for (int i=0; i<outputList.size(); i++) {
            output[i] = outputList.get(i);
        }

        System.out.println();


        // Sort last group.


        return output;
    }















    // 1:977
    public int[] sortedSquares(int[] A) {

        int[] sortedArray = new int[A.length];

        // iterate
        for (int i=0; i<A.length; i++) {
            A[i] = A[i] * A[i];
            unsortedList.add(A[i]);
        }

        sort(unsortedList);

        for (int i=0; i<sortedList.size(); i++) {
            sortedArray[i] = sortedList.get(i);
        }

       return sortedArray;

    }

    private ArrayList<Integer> sort(ArrayList<Integer> A) {

        sortedList = new ArrayList<>();

        for (int i=0; i <= A.size(); i++) {

            int leastIndex = findLeastIndex(A);

            sortedList.add(A.get(leastIndex));

            A.remove(leastIndex);

            i = 0;
        }

        return sortedList;
    }

    private int findLeastIndex(ArrayList<Integer> A) {

        int leastIndex = 0;

        if (A.size() == 1) {
            return 0;
        } else {
            for (int i = 0; i < A.size(); i++) {

                if (A.get(i) < A.get(leastIndex)) {
                    leastIndex = i;
                }
            }
        }

        return leastIndex;

    }



}
