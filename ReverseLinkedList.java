/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Jan 7, 2019
 * 
 *         This example is written in iterative manner... because recursion
 *         needs recursive stack which is extra space needed.
 */
public class ReverseLinkedList {

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

		Node headReversed = reverseLinkedList(head);

		while (headReversed != null) {

			System.out.print(headReversed.data + " ");
			headReversed = headReversed.next;
		}
	}

	private static Node reverseLinkedList(Node head) {

		Node prev = null;
		Node next = null;

		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;

		}
		return prev;
	}

}
