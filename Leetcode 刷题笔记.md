# Leetcode 刷题笔记

## 数据结构

### 链表

1. 在对链表进行操作时，一种常用的技巧是添加一个**哑节点**（dummy node），它的 next 指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。

   

#### 反转链表---经典链表题目

[Leetcode #206 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

![img](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

给你单链表的头节点 `head` ，请你反转链表，并返回反转后的链表。



**解法：**

1.递归

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        {return head;}
        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
```



2.迭代

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        while(current!=null)
        {
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
```



3.**头插法** (很巧妙的一个方法)即当链表新增一个节点，插入到head(t头)之前。

![img](https://pic.leetcode-cn.com/1c8927d9ff605502793d81ab344dbc17e16d6db2d8dd789045f56af432079519.gif)

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        {return head;}
        ListNode cur=head;
        while(head.next!=null)
        {
            ListNode t=head.next.next;
            head.next.next=cur;
            cur=head.next;
            head.next=t;
        }
        return cur;
    }
}

```

### 树



## 算法

#### 二分查找---基本功

[Leetcode #704 二分查找](https://leetcode-cn.com/problems/binary-search/)

二分查找是一种基于比较目标值和数组中间元素的教科书式算法。

**做到烂熟于胸，信手拈来**



**解法：**

```java
class Solution {
  public int search(int[] nums, int target) {
    int middle, left = 0, right = nums.length - 1;
    while (left <= right) {
      middle = left + (right - left) / 2;
      if (nums[middle] == target) return middle;
      if (target < nums[middle]) right = middle - 1;
      else left = middle + 1;
    }
    return -1;
  }
}

```

其中`middle = left + (right - left) / 2;`相比于`middle=(left+right)/2;`在数组非常大时更不容易溢出；

### 双指针

#### 两数之和---利用双指针快速缩减搜索空间

[Leetcode #167 两数之和-输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

给定一个已按照 **升序排列** 的整数数组 `numbers` ，请你从数组中找出两个数满足相加之和等于目标数 `target` 。

示例 1：

输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。



**解法：**

1.双循环暴力解

2.单循环+二分查找剩下那个值

**3.双指针（本质快速缩减搜索空间）**

通俗解释：如指针从numbers[0]移到numbers[1],那么0处必然不可能存在解。

eg: numbers[0]+numbers[3]=2+15>target=9,那么任意number[i]+number[3]>9,所以排除任何带有number[3]的可能解。

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0,end=numbers.length-1;
        while(start<end)
        {
            if(numbers[start]+numbers[end]==target)
            {return new int[]{start+1,end+1};}
            else if(numbers[start]+numbers[end]<target)
            {start++;}
            else
            {end--;}
        }
        return new int[] {-1,-1};
    }
}
```

具体解释见：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/

相似题目(用到缩减空间思想)：[Leetcode #11 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)     [Leetcode #240 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

#### 合并两个有序数组---想想反其道而行之

[Leetcode #88 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。



**解法：**

1.放一起快排

2.双指针+在额外数组空间排序

**3.逆向双指针（题目要求非递减排序，反其道而行之，在尾部非递增排序。巧妙的是使得nums1后面的位置永远足够容纳被插入的元素，不会产生nums1的元素被覆盖的情况。）**

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }
}
```



#### 环形链表-快慢指针的经典应用

[Leetcode #141环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

给定一个链表，判断链表中是否有环。

进阶：

你能用 O(1)（即，常量）内存解决此问题吗？

 

示例 1：

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。



**解法：**

1.快慢指针，若有环则指针必相遇。

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
        {return false;}
        ListNode fast=head.next;
        ListNode slow=head;
        while(slow!=fast)
        {
            if(fast==null||fast.next==null)
            {return false;}
            fast=fast.next.next;
            slow=slow.next;
        }
        return true;

    }
}
```







