/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Sep 14, 2018
 */

public class CheckLoopLinkedList {

	static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = head.next.next.next.next;

		boolean loopPresent = checkForLoopInLinkedList(head);

		System.out.println("Loop present in Linked List is " + loopPresent);

	}

	static boolean checkForLoopInLinkedList(Node head) {

		Node slowPointer = head;
		Node fastPointer = head;

		int nodeCount = 1;
		while (slowPointer != null && fastPointer != null) {

			if (nodeCount++ > 1 && (slowPointer.data == fastPointer.data)) {
				return true;
			}

			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

		}
		return false;

	}
}