package jianzhiOffer;

import java.util.Arrays;

public class FindKthNodeToTail {
    public static void main(String[] args) {
        ListNode listNode = FindKthToTail(ListNode.getList(Arrays.asList(1,2,3,4,5)),2);
        System.out.print(listNode == null ? null : listNode.val);
    }
    public static ListNode FindKthToTail(ListNode pHead, int k){
        ListNode fastNode = pHead;
        while (fastNode != null && k != 1){
            fastNode = fastNode.next;
            k--;
        }
        if(fastNode == null){
            return null;
        }
        while (fastNode.next != null){
            pHead = pHead.next;
            fastNode = fastNode.next;
        }
        return pHead;
    }
}
