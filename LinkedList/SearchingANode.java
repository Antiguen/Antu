package LinkedList;

public class SearchingANode {
    private Node head;
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public void insertAtPos(int data, int position) {
        // Handle insertion at the beginning (position 1 or less)
        if (position <= 1) {
            Node newNode = new Node(data);
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
        // Insert the new node after the current node
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }
    public Node searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null; // Node not found
    }
    public void printSearchingANode() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    public void deleteAfterNode(Node prevNode) {
        // Check if the list is empty or the given node is the last node
        if (head == null || prevNode.next == null) {
            System.out.println("The node to be deleted after does not exist!");
            return;
        }
        // Store the node to be deleted
        Node nodeToDelete = prevNode.next;
        // Update the next pointer of the previous node to skip the node to be deleted
        prevNode.next = nodeToDelete.next;
    }
    public static void main(String[] args) {
        SearchingANode list = new SearchingANode();
        // Create some initial nodes
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 4);
        //printing the original list
        System.out.print("Original list: ");
        list.printSearchingANode();
        // Search for a node with value 20
        Node foundNode = list.searchNode(20);
        if (foundNode != null) {
            System.out.println("\nNode found: " + foundNode.data);
        } else {
            System.out.println("Node with value 20 not found!");
        }
        // Search for a node with value 50
        foundNode = list.searchNode(50);
        if (foundNode != null) {
            System.out.println("\nNode found: " + foundNode.data);
        } else {
            System.out.println("Node with value 50 not found!");
        }
        Node nodeToDeleteAfter = list.searchNode(20);
        if (nodeToDeleteAfter != null) {
            list.deleteAfterNode(nodeToDeleteAfter);
            System.out.println("\nAfter deleting node after 20: ");
            list.printSearchingANode();
        } else {
            System.out.println("Node with value 20 not found for deletion!");
        }
    }

}
