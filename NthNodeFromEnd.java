/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Sep 25, 2018      
 */

public class NthNodeFromEnd {

	static Node head;

	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		int n = 3;

		Node nthNodeFromEnd = nthNodeFromEnd(head, n);
		
		System.out.println("Nth node from end is :: "+nthNodeFromEnd.data);

	}

	private static Node nthNodeFromEnd(Node node, int n) {
		
		
		Node slowPointer=head;
		Node fastPointer=head;
		
		while(n-->0){
			
			fastPointer=fastPointer.next;
			
		}
		
		while(fastPointer!=null){
			
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
		
		}
		
		return slowPointer;
		
	}
}
