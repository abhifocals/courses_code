package search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;

public class BinarySearchTree {

    static int timer;
    static HashMap<Integer, Integer> inTimeMap = new HashMap<>();
    static HashMap<Integer, Integer> outTimeMap = new HashMap<>();

    public static void main(String[] args) {
        int min = 0;
        int max = 10000;

        Node root = new Node(12);

        root.insert(root, 5);
        root.insert(root, 15);
        root.insert(root, 3);
        root.insert(root, 7);
        root.insert(root, 13);
        root.insert(root, 17);
        root.insert(root, 1);
        root.insert(root, 9);
        root.insert(root, 19);


        calcInOutTimes(root);

        boolean test = findIfConnected(19,15);

        System.out.println();
    }


    static class Node {
        int value;
        Node left, right;

        // This is for creating root node
        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(Node parent, int value) {

            if (value < parent.value) {

                if (parent.left == null) {
                    parent.left = new Node(value);
                } else {
                    insert(parent.left, value);
                }
            } else {

                if (parent.right == null) {
                    parent.right = new Node(value);
                } else {
                    insert(parent.right, value);
                }
            }
        }
    }


    private static int findHeight(Node root) {

        if (root == null) {
            return -1;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int height = max(leftHeight, rightHeight) + 1;

        return height;
    }


    private static boolean isBSTInOrderTraversal(Node root, int valueToCompareWith) {

        // Read Left Child
        if (root.left != null) {
            isBSTInOrderTraversal(root.left, valueToCompareWith);
        }

        // Read Value
        System.out.println(root.value);
        if (root.value < valueToCompareWith) {
            return false;
        }

        // Read Right Child
        if (root.right != null) {
            isBSTInOrderTraversal(root.right, root.value);
        }

        return true;
    }

    private static boolean isBST(Node root, int min, int max) {

        if (root == null) {
            return true;
        } else if (root.value > min && root.value < max
                && isBST(root.left, min, root.value)
                && isBST(root.right, root.value, max)) {
            return true;
        }

        return false;

    }


    private static Node deleteNode(Node root, int deleteValue) {

        // Edge case
        if (root == null) {
            return root;
        }

        // Look in left or right if needed
        else if (deleteValue < root.value) {
            root.left = deleteNode(root.left, deleteValue);
        } else if (deleteValue > root.value) {
            root.right = deleteNode(root.right, deleteValue);
        }


        // Meat of the function

        else {

            // Case 1: no children

            if (root.left == null && root.right == null) {
                root = null;
            }

            // Case 2: 1 child

            else if (root.left == null) {
                Node temp = root.right;
                root = temp;
                root.right = null;
            } else if (root.right == null) {
                Node temp = root.left;
                root = temp;
                root.left = null;
            } else {
                // Case 3: both left and right children
                Node temp = findMin(root.right);
                root.value = temp.value;
                root.right = deleteNode(temp, temp.value);
            }
        }

        return root;
    }

    private static Node findMin(Node root) {

        Node min = null;

        // if root has left, find min in root's left
        if (root.left != null) {
            root = findMin(root.left);
        }

        return root;
    }

    private static Node findMinIteratively(Node root) {

        Node min = null;

        if (root == null) {
            return root;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    private static void depthFirstTraversal(Node root) {

        if (root != null) {
            System.out.println(root.value);
        }

        if (root.left != null) {
            depthFirstTraversal(root.left);
        }

        if (root.right != null) {
            depthFirstTraversal(root.right);
        }
    }


    private static void breadthFirstTraversal(Node root) {

        // Make a queue
        Queue<Node> queue = new LinkedList<>();

        ((LinkedList<Node>) queue).add(root);

        while (!queue.isEmpty()) {

            Node current = ((LinkedList<Node>) queue).getFirst();

            System.out.println(current.value);

            if (current.left != null) {
                ((LinkedList<Node>) queue).add(current.left);
            }

            if (current.right != null) {
                ((LinkedList<Node>) queue).add(current.right);
            }

            ((LinkedList<Node>) queue).removeFirst();

        }

    }


    private static void calcInOutTimes(Node root) {

        // Increment timer
        timer++;

        // Update intime for this node
        inTimeMap.put(root.value, timer);

        // DFS this node
        if (root.left != null) {
            calcInOutTimes(root.left);
        }

        if (root.right != null) {
            calcInOutTimes(root.right);
        }

        // Increment timer
        timer++;

        // Update outtime for this node
        outTimeMap.put(root.value, timer);

    }

    private static boolean findIfConnected(int a, int b) {

        if ((inTimeMap.get(a) < inTimeMap.get(b)) && (outTimeMap.get(a) > outTimeMap.get(b)) ||
                (inTimeMap.get(b) < inTimeMap.get(a)) && (outTimeMap.get(b) > outTimeMap.get(a))) {
            return true;
        }
        return false;

    }


}
