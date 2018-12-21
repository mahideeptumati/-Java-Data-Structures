/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Sep 25, 2018
 */

class Node {

	int data;
	Node next;

	public Node(int data) {

		this.data = data;
	}
}

public class NthNodeFromEnd {

	static Node head;

	public static void main(String[] args) {

		NthNodeFromEnd n = new NthNodeFromEnd();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		NthNodeFromEnd.head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		printLinkedList();

		nthNodeFromEnd(5);

	}

	private static void printLinkedList() {

		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ->");
			node = node.next;
		}

	}

	
	private static void nthNodeFromEnd(int n){
		
		
		Node n1 = head,n2=head;
		
		int i=1;
		while(n2 !=null && i<=n){
			
			n2=n2.next;
			i++;
		}
		
		while(n1!=null && n2!=null){
			
			n1=n1.next;
			n2=n2.next;
		}
		
		System.out.println("\n"+n+"th element from end is "+n1.data);
		
		
	}
}
