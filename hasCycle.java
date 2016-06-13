/** FROM LEETCODE.COM - Given a linked list, determine if it has a cycle in it.
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public boolean hasCycle(ListNode head) {
        if (head == null)
            return false; 
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (true) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false; 
            }
                
            if (slow == null || fast == null)
                return false;
                
            if (slow.val == fast.val) 
                return true; 
        }
        
}
