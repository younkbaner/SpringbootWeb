package com.web.springbootweb.leetcode;

/**
 * @description: 力扣27：移除元素
 * 把数组中不等于指定值的元素，移到数组靠前的位置，等于指定元素的值，移动到靠后的位置，最后返回数组中不等于指定元素的个数
 * 思路：使用快慢指针的办法
 */
public class RemoveElement {

    public static void main(String[] args) {


        int[] nums = new int[6];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 5;
        nums[5] = 12;

        int val = 3;

        int i = removeElement(nums, val);
        System.out.println(i);
    }

    static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == val && nums[fast] != val) {
                //慢指针指向的元素等于给定值，快指针指向的元素不等于给定值，交换快慢指针指向的元素，达到把不等于给定值的元素往前挪，等于给定值的元素往后挪
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
            } else if (nums[slow] == val && nums[fast] == val) {
                //如果快慢指针指向的元素都等于给定值，快指针往后走，用来去找不等于给定值的元素
                fast++;
            } else {
                //如果快慢指针在同一个位置啦，那就往后移动快指针，用来去找不等于给定值的元素
                if (fast == slow) {
                    fast = slow + 1;
                }
                //如果快慢指针不再同一个位置，那就把慢指针往后走，（说明慢指针指向的元素就不等于给定值，可以留在前半部分)
                slow++;

            }
        }
        return slow;
    }

}
