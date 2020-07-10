package leetcode;

import java.util.HashMap;

import static java.lang.String.valueOf;

public class Strings {


    int countL = 0;
    int countR = 0;
    int output = 0;
    StringBuilder newString = new StringBuilder();



    public static void main(String[] args) {

//        // 1
//        new Strings().balancedStringSplit("RLRLRL");
//
//        // 2
//        char[] test = new char[]{'H', 'E', 'L', 'L', 'O'};
//        new Strings().reverseString(test);
//
//        // 3
//        new Strings().addStrings("408", "5");

//        new Strings().firstUniqChar("leetcode");

//        new Strings().removeDuplicates("abbbabaaa");

//            new Strings().generateTheString(4);

        new Strings().reverseWords("Let's take LeetCode contest");

    }


    // 6: 557
    public String reverseWords(String s) {
        StringBuilder sentence = new StringBuilder();

        // string into words
        String[] words = s.split(" ");

        for (int i=0; i<words.length; i++) {
            // reverse word
            StringBuilder sb = new StringBuilder(words[i]);
            sentence.append(sb.reverse().toString() + " ");
        }

        sentence.replace(sentence.length()-1,sentence.length(),"");

        System.out.println(sentence.toString());

        return sentence.toString();
    }




























    // 5:1374
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();

        // If n is even
        if ((n%2)==0) {
            for (int i=0; i < n-1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }


        else {

            // If n is odd
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }

        return sb.toString();

    }


    // 4:1047
    public String removeDuplicates(String S) {

        StringBuilder oldString = new StringBuilder(S);
        newString = new StringBuilder();

        char[] chars = S.toCharArray();

        System.out.println("Old String: " + oldString.toString());
        newString.append(chars[0]);
        System.out.println("New String: " + newString.toString());

        for (int i = 0; i < chars.length; i++) {

            System.out.println("Index: " + i);
            if (i > 0 && chars[i] == chars[i - 1]) {
                if (newString.length() >= 1 && newString.toString().toCharArray()[newString.length()-1] == chars[i]) {
                    newString.replace(newString.length() - 1, newString.length(), "");
                } else {
                    newString.append(chars[i]);
                }

                System.out.println("New String: " + newString.toString());
            }

            else if (i > 0) {
                newString.append(chars[i]);
                System.out.println("New String: " + newString.toString());
            }
        }

        System.out.println("New String: " + newString.toString());

        if (!newString.toString().equals(oldString.toString())) {
            oldString = newString;

            if (!newString.toString().isEmpty()) {
                removeDuplicates(newString.toString());
            }

        }

        return newString.toString();
    }














    // 4:387
    public int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> countMap = new HashMap<>();
        int desiredIndex = 99999999;

        // iterate
        for (int i = 0; i < chars.length; i++) {

            if (countMap.get(chars[i]) != null && countMap.get(chars[i]) >= -1) {
                countMap.put(chars[i], -1);
            } else {
                countMap.put(chars[i], i);
            }
        }

        for (int index : countMap.values()) {
            if (index >= 0 && index < desiredIndex) {
                desiredIndex = index;
            }
        }

        if (countMap.size() == 0) {
            desiredIndex = -1;
        }

        if (desiredIndex == 99999999) {
            desiredIndex = -1;
        }

        return desiredIndex;
    }


    // 3:415
    public String addStrings(String num1, String num2) {

        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();

        // Find array w/greater length
        int length1 = array1.length;
        int length2 = array2.length;
        int biggerLength = 0;
        int carryForward = 0;

        if (length1 >= length2) {
            biggerLength = length1;
        } else {
            biggerLength = length2;
        }

        char[] newArray = new char[biggerLength];


        if (biggerLength == 1) {

            int value1 = Integer.parseInt(String.valueOf(array1[0]));
            int value2 = Integer.parseInt(String.valueOf(array2[0]));
            int sum = value1 + value2;

            sb.append(sum);


        }

        else {
            // Add last chars + CF
            for (int i=0; i< biggerLength; i++) {

                int char1 = 0;
                int char2 = 0;
                char[] sumArray = null;

                try {
                    char1 = Integer.parseInt(valueOf(array1[length1-1-i]));
                }
                catch (IndexOutOfBoundsException e) {

                }
                System.out.println("Char1: " + char1);

                try {
                    char2 = Integer.parseInt(valueOf(array2[length2-1-i]));
                }
                catch (IndexOutOfBoundsException e) {

                }
                System.out.println("Char2: " + char2);

                Integer sum = char1 + char2 + carryForward;
                sumArray = valueOf(sum).toCharArray();
                System.out.println("Sum: " + sum);

                if (sum >= 10) {
                    newArray[newArray.length-1-i] =  sumArray[1];
                    carryForward = Integer.parseInt(valueOf(sumArray[0]));
                    System.out.println("CarryForward: " + carryForward);

                    System.out.println();
                }

                else {
                    newArray[newArray.length-1-i] =  sumArray[0];
                    carryForward = 0;
                    System.out.println();
                }

            }

            if (carryForward > 0) {

                sb.append(carryForward);




            }

            for (int i=0; i < newArray.length; i++) {
                if (i == 0 && newArray[0] > 0) {
                    sb.append(newArray[0]);
                } else {
                    sb.append(newArray[i]);
                }

                System.out.println(sb.toString());
            }
        }

        return sb.toString();
    }












    // 2:344
    public void reverseString(char[] s) {

        int n = s.length;

        char[] newArray = new char[n];

        for (int i = 0; i < n; i++) {
            newArray[i] = s[n - 1 - i];
        }

        s = newArray;
        System.out.println("Output: " + new String(s));
    }


    // 1:1221
    public int balancedStringSplit(String s) {
        s.toUpperCase();
        countL = 0;
        countR = 0;


        // Base Case
        if (s.length() == 0 || s == null) {
            return output;
        }

        // Get Count
        for (int i = 0; i < s.length(); i++) {
            System.out.println("String: " + s);
            System.out.println("Index: " + i);

            getCharCount(s.charAt(i));

            // if countR == count L.
            if (countR == countL) {

                // Increment Output
                output++;

                // Form Substring
                s = s.substring(i + 1);
                break;
            }
        }

        balancedStringSplit(s);

        System.out.println(output);
        return output;
    }


    private void getCharCount(Character c) {

        if (c == 'L') {
            countL++;
        } else {
            countR++;
        }
    }


}
