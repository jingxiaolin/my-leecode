package jianzhiOffer;

import java.util.Objects;

/**
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=23257&ru=/practice/6ab1d9a29e88450685099d45c9e31e46&qru=/ta/coding-interviews/question-ranking
 这破题的难点主要在于理解题意，两个链表相交，之后的部分完全相等。可以理解为两个链表是同时结束的，但不是同时开始的。可以利用这个特点解决问题
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(7);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode11 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode33 = new ListNode(3);
        ListNode listNode44 = new ListNode(6);
        ListNode listNode55 = new ListNode(7);
        listNode11.next = listNode22;
        listNode22.next = listNode33;
        listNode33.next = listNode44;
        listNode44.next = listNode55;
        ListNode newHead = findFirstCommon3(listNode,listNode11);
        System.out.println(newHead == null ? newHead : newHead.val);
    }
    public static ListNode findFirstCommon(ListNode pHead1,ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int length1 = 0,length2 = 0;
        ListNode tmp1 = pHead1,tmp2 = pHead2;
        while (tmp1 != null){
            length1++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null){
            length2++;
            tmp2 = tmp2.next;
        }
        int lengthGap = Math.abs(length1-length2);
        while (lengthGap!=0){
            if(length1>=length2){
                pHead1 = pHead1.next;
            }else {
                pHead2 = pHead2.next;
            }
            lengthGap--;
        }
        ListNode resListNode = null;
        while (pHead1 != null && pHead2 != null){
            if(Objects.equals(pHead1.val,pHead2.val)){
                resListNode = pHead1;
                break;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return resListNode;
    }
    //这种方法的空间复杂度是O(n),把list1和list2相加，然后再同时遍历
    public static ListNode findFirstCommon2(ListNode pHead1,ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode newList1 = pHead1,newList2 = pHead2;
        while (newList1.next != null){
            newList1 = newList1.next;
        }
        newList1.next = pHead2;
        while (newList2.next != null){
            newList2 = newList2.next;
        }
        newList2.next = pHead1;
        ListNode resListNode = null;
        while (pHead1 != null && pHead2 != null){
            if(pHead1.val == pHead2.val){
                resListNode = pHead1;
                break;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return resListNode;
    }
    //这种方法其实和上面加和的方式同理，但是是通过逻辑的形式，没有赤裸裸的加和。
    //本地一直返回null，是因为相同的节点都是new出来的，所以newList1！=newList2 一直为true
    public static ListNode findFirstCommon3(ListNode pHead1,ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode newList1 = pHead1,newList2 = pHead2;
        while (newList1 != newList2){
            newList1 = (newList1==null) ? pHead2 : newList1.next;
            newList2 = (newList2==null) ? pHead1 : newList2.next;
        }
        return newList1;
    }
}
