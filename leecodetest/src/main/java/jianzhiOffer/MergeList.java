package jianzhiOffer;

public class MergeList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode11 = new ListNode(2);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode33 = new ListNode(5);
        listNode11.next = listNode22;
        listNode22.next = listNode33;
        ListNode newHead = mergeRecursion(listNode,listNode11);
        System.out.println(newHead);
    }
    public static ListNode merge(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null){
            return list1 == null?list2:list1;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (list1 != null && list2 != null){
            if(list2.val<= list1.val){
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }else {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if(list1 == null){
            cur.next = list2;
        }else {
            cur.next = list1;
        }
        return newHead.next;
    }
    public static ListNode mergeRecursion(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null){
            return list1 == null?list2:list1;
        }
        if(list1.val <= list2.val){
            list1.next = mergeRecursion(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeRecursion(list1,list2.next);
            return list2;
        }
    }
}
