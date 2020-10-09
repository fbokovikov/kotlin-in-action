package leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        // 1 -> 4 -> 9
        ListNode firstList = new ListNode(1);
        firstList.next = new ListNode(4);
        firstList.next.next = new ListNode(9);

        // 1 -> 3 -> 8
        ListNode secondList = new ListNode(1);
        secondList.next = new ListNode(3);
        secondList.next.next = new ListNode(8);

        // 1 -> 2 -> 12
        ListNode thirdList = new ListNode(1);
        thirdList.next = new ListNode(2);
        thirdList.next.next = new ListNode(12);

        ListNode result = mergeKListsV2(new ListNode[] { firstList, secondList, thirdList } );
        System.out.println(result);

    }

    // O(NK)
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = mergeTwo(result, lists[i]);
        }

        return result;
    }

    private static ListNode mergeTwo(ListNode first, ListNode second) {
        ListNode result = new ListNode();
        ListNode curPos = result;

        while (first != null || second != null) {
            if (first == null) {
                curPos.next = new ListNode(second.val);
                second = second.next;
            } else if (second == null)  {
                curPos.next = new ListNode(first.val);
                first = first.next;
            } else {
                int minValue = Math.min(first.val, second.val);
                if (first.val <= second.val) {
                    first = first.next;
                } else {
                    second = second.next;
                }
                curPos.next = new ListNode(minValue);
            }
            curPos = curPos.next;
        }

        return result.next;
    }

    // O(N logK)
    public static ListNode mergeKListsV2(ListNode[] lists) {

        Queue<Integer> queue = new PriorityQueue<>();

        for (ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                queue.offer(head.val);
                head = head.next;
            }
        }

        ListNode result = new ListNode();
        ListNode temp = result;

        while (!queue.isEmpty()) {
            int minElement = queue.poll();
            temp.next = new ListNode(minElement);
            temp = temp.next;
        }

        return result.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; };
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        StringBuilder res = new StringBuilder();

        ListNode head = this;
        while (head != null) {
            res.append(head.val);
            head = head.next;
            if (head != null) {
                res.append(" -> ");
            }
        }

        return res.toString();
    }
}