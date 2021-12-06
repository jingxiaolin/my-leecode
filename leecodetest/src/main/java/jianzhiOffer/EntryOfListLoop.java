package jianzhiOffer;

public class EntryOfListLoop {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        /*ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);*/
        listNode.next = listNode2;
        /*listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode3;*/
        ListNode newHead = getEntryNode(listNode);
        System.out.println(newHead == null ? newHead : newHead.val);
    }
    //快慢指针，快指针一次走两步，慢指针一次走一步
    //结论1，一个链表有环，快慢指针一定能相遇
    //结论2，一个指针从相遇点出发，一个指针从头出发，两个指针再次相遇，就是环的入口
    public static ListNode getEntryNode(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode commonNode = null;
        ListNode fastNode = pHead,slowNode = pHead;
        while (true){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == null || fastNode.next == null || fastNode.next.next == null){
                commonNode = null;
                break;
            }
            if(fastNode == slowNode){
                commonNode = fastNode;
                break;
            }
        }
        if(commonNode == null){
            return commonNode;
        }
        while (commonNode != pHead){
            commonNode = commonNode.next;
            pHead = pHead.next;
        }
        return commonNode;
    }
}
