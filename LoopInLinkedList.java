/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Sep 14, 2018
 */

class Node {

	int data;
	Node next;

	Node(int data) {

		this.data = data;
		this.next = null;
	}

}

public class LoopInLinkedList {

	Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoopInLinkedList l = new LoopInLinkedList();

		l.head = new Node(1);

		Node second = new Node(2);

		Node third = new Node(3);

		Node fourth = new Node(4);

		Node fifth = new Node(42);
 
		Node sixth = new Node(412);

		Node seventh = new Node(20);

		Node eight = new Node(25);

		l.head.next = second;

		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eight;
		eight.next=fifth;

		//l.printLinkedList();

		
		 
		
	}

	/**
	 * 
	 */
	private void printLinkedList() {
		Node n = head;

		while (n != null) {

			System.out.print(n.data + " -> ");
			n = n.next;
		}

	}

}
