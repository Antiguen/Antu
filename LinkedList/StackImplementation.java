package LinkedList;
import java.util.NoSuchElementException;
public class StackImplementation {
    private Node top;
    // Node class representing a node in the linked list
    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    // Pushes an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    // Pops the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty"); // Use java.util.NoSuchElementException
        }
        int data = top.data;
        top = top.next;
        return data;
    }
    // Peeks at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty"); // Use java.util.NoSuchElementException
        }
        return top.data;
    }
    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
