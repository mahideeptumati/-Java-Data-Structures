/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Sep 10, 2018
 */

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;

	}

}

public class AddElementInLinkedList {

	Node head;
	
	public static void main(String args){
		AddElementInLinkedList node=new AddElementInLinkedList();
		node.head=new Node(1);
		
		
	}
	
}
