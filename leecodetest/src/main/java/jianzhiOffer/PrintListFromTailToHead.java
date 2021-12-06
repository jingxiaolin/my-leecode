package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintListFromTailToHead {
    public static void main(String[] args) {
        System.out.println(printListFromTailToHead2(ListNode.getList(Arrays.asList(1,2,3))));
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        ListNode originNode = listNode;
        while(originNode!=null){
            resList.add(0,originNode.val);
            originNode = originNode.next;
        }
        return resList;
    }
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        listNode = revertListNodeRecursion(listNode);
        ArrayList<Integer> resList = new ArrayList<Integer>();
        while(listNode!=null){
            resList.add(listNode.val);
            listNode = listNode.next;
        }
        return resList;
    }
    //递归
    public static ListNode revertListNodeRecursion(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        //newHead为了把尾部元素带出来
        ListNode newHead = revertListNodeRecursion(listNode.next);
        //改变指向只需这一句
        listNode.next.next = listNode;
        //不把next置空，就成环了
        listNode.next = null;
        return newHead;
    }
    /*//原地逆置
    public static ListNode revertListNodeYuanDi(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode pre = listNode,end = listNode.next;
        while (end != null){
            listNode.next = listNode.next.next;
            end.next = pre;
            listNode =
        }
        return listNode;
    }*/
    public static ListNode revertListNodePuTongDieDai(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode pre = null,cur = listNode,end = null;
        while (cur != null){
            end = cur.next;
            cur.next = pre;
            pre = cur;
            cur = end;
        }
        return pre;
    }
    public static ListNode revertListNodeTouCha(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode pre = new ListNode(listNode.val);
        listNode = listNode.next;
        while (listNode != null){
            ListNode newNode = new ListNode(listNode.val);
            newNode.next = pre;
            pre = newNode;
            listNode = listNode.next;
        }
        return pre;
    }

}
