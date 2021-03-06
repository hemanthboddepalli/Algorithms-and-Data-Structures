import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DoublyLinkedList<T> {
  
    public class Node {
		public T data;
		public Node nextNode;
		public Node prevNode;
	}
	
	public Node headNode;
	public int size;
	
    public DoublyLinkedList() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

	public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }
	
	public void insertAtHead(T data) {
		Node node = new Node();
		node.data = data;
		node.nextNode = headNode;
		if (headNode != null) {
			headNode.prevNode = node;
		}
		headNode = node;
		size++;
	}
	
	public void insertAtEnd(T data) {
		Node node = new Node();
		node.data = data;
		if (isEmpty()) {
			headNode = node;
		}
		else {
			Node prevNode = headNode;
			while (prevNode.nextNode != null) {
				prevNode = prevNode.nextNode;
			}
			prevNode.nextNode = node;
			node.prevNode = prevNode;
		}		
		size++;
	}
	
	public void insertAfter(T data, T previous) {
		Node node = new Node();
		node.data = data;
		if (isEmpty()) {
			headNode = node;
		}
		else {
			Node prevNode = headNode;
			while (prevNode.data != previous) {
				prevNode = prevNode.nextNode;
			}
			Node nextNode = prevNode.nextNode;
			if (nextNode != null) {
				nextNode.prevNode = node;
			}
			node.nextNode = nextNode;
			node.prevNode = prevNode;
			prevNode.nextNode = node;
		}
		size++;
	}
	
	public boolean searchNode(T data) {
		Node node = headNode;
		while (node != null) {
			if (node.data == data) {
				return true;
			}
			node = node.nextNode;
		}
		return false;
	}
	
	public void deleteAtHead() {
		if (isEmpty()) {
			return;
		}
		headNode = headNode.nextNode;
		size--;
	}
	
	public void deleteByValue(T data) {
		if (isEmpty()) {
			return;
		}
		if (headNode.data == data) {
			deleteAtHead();
			return;
		}
		Node node = headNode, prevNode = null;
		while (node != null) {
			if (node.data == data) {				
				prevNode.nextNode = node.nextNode;
				if (node.nextNode != null) {
					node.nextNode.prevNode = prevNode;
				}
				size--;
				return;
			}
			prevNode = node;
			node = node.nextNode;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> sl = new DoublyLinkedList<Integer>();
		sl.insertAtHead(10); sl.insertAtHead(20); sl.insertAtEnd(40); sl.insertAtHead(30);
		sl.insertAfter(50, 40);
		sl.printList();
		sl.deleteAtHead();
		sl.printList();
		sl.deleteByValue(10);
		sl.printList();
		sl.deleteByValue(50);
		sl.printList();
	}
}
