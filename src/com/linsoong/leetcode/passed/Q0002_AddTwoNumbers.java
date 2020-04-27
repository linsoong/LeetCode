package com.linsoong.leetcode.passed;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class Q0002_AddTwoNumbers {

	public static void main(String[] args) {

		Q0002_AddTwoNumbers q2 = new Q0002_AddTwoNumbers();

		q2.VerifyResult();
	}
	
	public void VerifyResult() {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode res = addTwoNumbers(l1, l2);
		
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = null;
		ListNode temp = null;
		int count = 0;
		while (count == 1 || l1 != null || l2 != null) {
			if(res == null) {
				res = new ListNode(((l1==null?0:l1.val) + (l2==null?0:l2.val) + count) % 10);
				temp = res;
			}else {
				temp.next = new ListNode(((l1==null?0:l1.val) + (l2==null?0:l2.val) + count) % 10);
				temp = temp.next;
			}

			if (((l1==null?0:l1.val) + (l2==null?0:l2.val) + count) >= 10) {
				count = 1;
			} else {
				count = 0;
			}
			
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}

		return res;
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
