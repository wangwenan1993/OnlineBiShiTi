package iie.cloud.yuantiku;

import iie.cloud.bean.Beans.*;
import iie.cloud.util.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author wangwenan
 * @data 2018/8/25 11:13
 * 将一个双向链表分成两个链表，分别对应第偶数个节点和第奇数个节点
 */
public class SplitDoubleLinkedList {

    public static void main(String[] args) {
        DoubleNode root = ListUtil.constructDoubleList(2);
        ListUtil.printList(root);
        ArrayList<DoubleNode> list = split(root);
        ListUtil.printList(list.get(0));
        ListUtil.printList(list.get(1));
    }

    public static ArrayList<DoubleNode> split(DoubleNode root) {
        DoubleNode p1 = root, p2 = root;
        if(root == null) return new ArrayList<DoubleNode>(Arrays.asList(p1, p2));
        DoubleNode curr = root.next;
        DoubleNode pre = root;
        p2 = root.next;
        if(curr != null) {
            curr.pre = null;
        }
        while (curr != null) {
            pre.next = curr.next;
            if(curr.next != null) {
                curr.next.pre = pre;
            }
            pre = curr;
            curr = curr.next;
        }
        return new ArrayList<DoubleNode>(Arrays.asList(p1, p2));
    }
}
