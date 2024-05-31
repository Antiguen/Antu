package LinkedList;

public class DeleteANode {
    private Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public void insertAtPos(int data, int position) {
        // Create the new node
        Node newNode = new Node(data);
        // Handle insertion at the beginning (position 1 or less)
        if (position <= 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        // Traverse to the node before the insertion position
        Node current = head;
        int counter = 1;
        while (current != null && counter < position - 1) {
            current = current.next;
            counter++;
        }
        // Check if position is beyond the list length
        if (current == null) {
            System.out.println("Invalid position: " + position);
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    public void deleteAtPosition(int position) {
        // Handle deletion of the head node (position 1)
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        int counter = 1;
        while (current != null && counter < position - 1) {
            current = current.next;
            counter++;
        }
        if (current == null || current.next == null) {
            System.out.println("Invalid position: " + position);
            return;
        }
        current.next = current.next.next;
    }
    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        DeleteANode list = new DeleteANode();
        // Create some initial nodes
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 4);
        // printing list before deletion
        System.out.print("Original list: ");
        list.printLinkedList();
        // Delete a node at position 2
        list.deleteAtPosition(2);
        System.out.println("\nAfter deleting node at position 2: ");
        list.printLinkedList();
        //deleting at an invalid position
        list.deleteAtPosition(6);
    }

}
