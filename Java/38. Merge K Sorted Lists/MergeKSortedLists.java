/***************************************************************************************************** 
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 10^4.

 ******************************************************************************************************/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length%2==1){
            int l = lists.length/2 + 1;
            ListNode[] ls = new ListNode[l];
            for(int i=0; i<l-1; i++){
                ls[i] = merge(lists[2*i], lists[2*i+1]);
            }
            ls[l-1] = lists[lists.length-1];
            return mergeKLists(ls);
        }else{
            int l = lists.length/2;
            ListNode[] ls = new ListNode[l];
            for(int i=0; i<l; i++){
                ls[i] = merge(lists[2*i], lists[2*i+1]);
            }
            return mergeKLists(ls);
        }
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1==null){
            tail.next = list2;
        }
        if(list2==null){
            tail.next = list1;
        }
        return dummy.next;
    }
}
