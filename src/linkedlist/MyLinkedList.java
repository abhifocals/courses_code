package linkedlist;

import java.util.Stack;

public class MyLinkedList {

    static Node head;

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList();

        Node node = new Node(2);
        myLinkedList.insert(node);
        myLinkedList.insert(new Node(5));
        myLinkedList.insert(new Node(7));
        myLinkedList.insert(new Node(4));


        //head = myLinkedList.head;
        //reverseLinkedListUsingRecursion(head);
        //myLinkedList.head = head;

        System.out.println();

    }


    private static void reverseLinkedListUsingRecursion(Node current) {

        // This is only called for last node in the list during recursion
        if (current.next == null) {
            head = current;
            return;
        }

        reverseLinkedListUsingRecursion(current.next);

        // This executes for second last element in the list
        Node temp = current.next;

        // In solution, current node (second last), will be last (current.next) node's next
        temp.next = current;

        // This is to handle the next of first node (otherwise not needed)
        current.next = null;
    }




    /*
    Reverse a LinkedList iteratively by adjusting links (and not moving around data).
    */

    private static void reverseLinkedListIteratively(LinkedList linkedList) {

        Node previous = null;
        Node next = null;

        // Start with head
        Node current = linkedList.head;

        while (current != null) {

            // Get the next node so you can move to it
            next = current.next;

            // In final solution, current's next will be null. Previous fills this bill.
            current.next = previous;


            // Make previous as current
            previous = current;

            // Move to next
            current = next;
        }

        linkedList.head = current;

    }


    ///////// ***** /////////


    static class Node {

        int value;
        Node next;


        public Node(int value) {
            this.value = value;
            next = null;
        }
    }


    static class LinkedList {

        Node head;

        void insert(Node node) {

            // Make this the head if there's none
            if (head == null) {
                this.head = node;
            }


            // Else iterate through the list and add it to the end
            else {

                Node current = head;

                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }
    }
}


