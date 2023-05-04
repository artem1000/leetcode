package leetcode.twosum;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,4,3,90};
        int target = 0;
        long start = System.nanoTime();
        int[] result = twoSum(nums, target);
        long end = System.nanoTime();
        System.out.println(end-start);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] retVal = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > target - nums[i]) continue;
                if (nums[i] + nums[j] == target){
                    retVal[0] = i;
                    retVal[1] = j;
                    return retVal;
                }
            }
        }
        return retVal;
    }
}
