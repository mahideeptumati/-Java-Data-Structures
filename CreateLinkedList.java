/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Sep 10, 2018
 */
// Linked list
class Node {

	int data;
	Node next;

	public Node(int data) {

		this.data = data;
		next = null;

	}

}

public class CreateLinkedList {

	public Node head;

	public static void main(String args[]) {

		CreateLinkedList l = new CreateLinkedList();

		l.head = new Node(1);

		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);

		l.head.next = second;
		second.next = third;
		third.next = fourth;
		l.printNodesLinkedList();

	}

	void printNodesLinkedList() {

		Node n = head;
		while (n != null) {

			System.out.print(n.data + "  ");
			n = n.next;
		}

	}

}
