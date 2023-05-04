package leetcode.easy;

import java.util.Arrays;
/*
* Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
* */
public class PalindromeNumber {

    public static void main(String[] args) {
        int target = 121;
        long start = System.nanoTime();
        boolean result = isPalindrome(target);
        long end = System.nanoTime();
        System.out.println(end-start);
        System.out.println(result);
    }
    public static boolean isPalindrome(int target) {
        if (target < 0 ) return false;
        if (target < 10 ) return true;
        int reverse = 0;
        int x = target;
        while(x != 0)
        {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x = x/10;
        }
        return target == reverse;
        }
}
