package LinkedList;

public class InsertANode {
    private Node head;
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public void insertAtPos(int data, int position) {
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
    public void printInsertANode() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        InsertANode list = new InsertANode();

        // Create some initial nodes
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        //printing the original list
        System.out.print("Original list: ");
        list.printInsertANode();
        // Insert a new node at position 2
        list.insertAtPos(15, 2);
        System.out.println("\nAfter inserting 15 at position 2: ");
        list.printInsertANode();
        // Try inserting at an invalid position
        list.insertAtPos(40, 5);
    }
}
