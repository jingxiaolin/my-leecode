package jianzhiOffer;

import java.util.List;

public class ListNode {
    public  int val;
    public  ListNode next;

    public ListNode(int value) {
        this.val = value;
    }

    public static ListNode getList(List<Integer> toListNodeList){
        ListNode listNode = new ListNode(toListNodeList.get(0));
        ListNode tmp = listNode;
        for (int i = 1; i < toListNodeList.size(); i++) {
            Integer value = toListNodeList.get(i);
            ListNode Node = new ListNode(value);
            tmp.next = Node;
            tmp = tmp.next;
        }
        return listNode;
    }
}
