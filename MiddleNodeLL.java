/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Jan 7, 2019
 */
public class MiddleNodeLL {

	/**
	 * @param args
	 */

	static Node head;

	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		Node middleNode = getMiddleElement(head);

		System.out.println("Middle Node of the linked list is :: " + middleNode.data);

	}

	static Node getMiddleElement(Node head) {

		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer.next != null && fastPointer.next.next != null) {

			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return slowPointer;

	}

}
