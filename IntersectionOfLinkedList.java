/**
 * 
 */
package com.LinkedList;

/**
 * @author Mahideep Tumati
 *
 *         Created on Jan 7, 2019
 * 
 *         // this example is written by assuming that there is a loop for
 *         sure... To check if loop is there or not refer
 *         CheckLoopLinkedList.java file
 */

public class IntersectionOfLinkedList {

	static Node head;
	static Node head1;

	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		head1 = new Node(-1);
		head1.next = new Node(-2);
		head1.next.next = new Node(-3);
		head1.next.next.next = new Node(-4);
		head1.next.next.next.next = new Node(4);
		head1.next.next.next.next.next = new Node(5);
		head1.next.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next.next = new Node(7);

		Node intersectionNode = getIntersectionNodeOfLinkedList(head, head1);

		System.out.println("Data in the intersection node of two linked lists is ::: " + intersectionNode.data);

	}

	static Node getIntersectionNodeOfLinkedList(Node head, Node head1) {

		int countOfheadList = 0;
		int countOfhead1List = 0;

		Node headCopy = head;
		Node head1Copy = head1;
		while (headCopy != null) {

			headCopy = headCopy.next;
			countOfheadList++;
		}

		while (head1Copy != null) {

			head1Copy = head1Copy.next;
			countOfhead1List++;
		}

		if (countOfhead1List > countOfheadList) {

			int differenceCount = countOfhead1List - countOfheadList;
			while (differenceCount-- > 0) {
				head1 = head1.next;

			}

		}

		else if (countOfheadList > countOfhead1List) {

			int differenceCount = countOfheadList - countOfhead1List;
			while (differenceCount-- > 0) {
				head = head.next;
			}

		}

		while (head != null && head1 != null) {
			if (head.data == head1.data)
				return head;

			head = head.next;
			head1 = head1.next;
		}

		return null;

	}

}
