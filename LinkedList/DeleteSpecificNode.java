package LinkedList;

public class DeleteSpecificNode {
    private Node head;
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public void insertAtPos(int data, int position) {
    }
    public void deleteAfterNode(Node prevNode) {
        // Check if the list is empty or the given node is the last node
        if (head == null || prevNode.next == null) {
            System.out.println("The node to be deleted after does not exist!");
            return;
        }
        Node nodeToDelete = prevNode.next;
        // Update the next pointer of the previous node to skip the node to be deleted
        prevNode.next = nodeToDelete.next;
    }
    public void printDeleteSpecificNode() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    // Helper method to find a node by its data (replace with your actual implementation)
    public static Node findNode(Node head, int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        return current;
    }
    public static void main(String[] args) {
        DeleteSpecificNode list = new DeleteSpecificNode();
        // Create some initial nodes
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 4);
        //print Original list
        System.out.print("Original list: ");
        list.printDeleteSpecificNode();  // Call the print method here
        // Find the node with data 20 (assuming a method to find a node exists)
        Node nodeToDeleteAfter = DeleteSpecificNode.findNode(list.head, 20);
        if (nodeToDeleteAfter != null) {
            list.deleteAfterNode(nodeToDeleteAfter);
            System.out.println("\nAfter deleting node after 20: ");
            list.printDeleteSpecificNode(); // Call the print method here (assuming it exists)
        } else {
            System.out.println("Node with data 20 not found!");
        }
    }
}
