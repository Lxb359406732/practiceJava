# 递归

何为递归？程序反复调用自身即是递归。

**解决递归的关键**

1. **找整个递归的终止条件：递归应该在什么时候结束？**
2. **找返回值：应该给上一级返回什么信息？**
3. **本级递归应该做什么：在这一级递归中，应该完成什么任务？**

例子如：

[Leetcode21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

[Leetcode24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

***以Leetcode24*为例：**

1. **找终止条件。** 什么情况下递归终止？没得交换的时候，递归就终止了呗。因此当链表只剩一个节点或者没有节点的时候，自然递归就终止了。
2. **找返回值。** 我们希望向上一级递归返回什么信息？由于我们的目的是两两交换链表中相邻的节点，因此自然希望交换给上一级递归的是已经完成交换处理，即已经处理好的链表。
3. **本级递归应该做什么。** 结合第二步，看下图！由于只考虑本级递归，所以这个链表在我们眼里其实也就三个节点：head、head.next、已处理完的链表部分。而本级递归的任务也就是交换这3个节点中的前两个节点，就很easy了。

~~~~~~java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        {return head;}
        ListNode next=head.next;    
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }
}
~~~~~~

