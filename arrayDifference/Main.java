package leetcode.arrayDifference;

import java.util.*;
import java.util.stream.Collectors;
/*
* Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].*/

public class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[]{68,523,894,495,181,496,192,583,241,644,218,77,472,764,697,209,351,431,364,380,349,230,189,95,73,81,331,70,847,177,991,298,569,193,301,437,920,662,836,514,127,926,515,316,203,919,970,617,790,801,966,876,533,428,276,820,332,540,82,417,162,317,539,234,548,93,841,634,333,520,979,76,132,845,126,776,316,723,35,447,22,848,93,892,591,326,858,817,462,287,31,379,736,829,237,890,802,346,22,305,116,589,567,683,832,339,908,122,434,853,309,732,173,341,308,980,366,234,331,983,37,834,381,307,154,324,30,928,737,219,838,982,279,436,540,923,231,766,765,615,753,351,399,104,764,668,183,333,705,647,116,773,440,790,789,280,686,29,215,602,491,42,173,650,18,45,596,983,664,549,530,341,91,164,109,145,978,447,968,353,295,748,864,78,152,696,61,499,597,667,985,605,747,26,898,592,30,221,435,931,82,831,389,334,145,209,247,477,627,950,248,762,580,133,878,236,768,252,761,869,926,542,361,47,607,593,802,814,68,526,665,939,97,167,722,153,688,32,358,799,536,836,34,597,937,64,248,488,874,264,975,580,172,345,137,953,246,220,783,518,599,366,624,937,669,808,290,859,949,998,532,849,613,618,432,388,136,502,286,590,356,277,575,683,363,837,796,430,546,100,712,33,51,432,894,171,489,955,34,510,594,262,355,612,401,935,18,657,628,963,774,189,535,456,315,584,658,717,155,363,402,411,866,204,546,240,808,79,864,37,656,160,391,565,698,851,255,798,452,34,256,55,648,981,773,8,539,910,730,778,7,828,873,773,689,139,428,397,217,80,195,123,103,417,731,706,699,201,590,225,190,533,710,408,188,173,391,967,139,550,915,182,874,817,478,487,641,671,454,668,913,830,23,90,228,835,685,406,929,255,506,628,328,794,949,879,430,931,782,436,317,662,402,1,144,312,199,649,256,514,468,406,536,311,34,716,527,442,153,836,776,536,879,483,634,954,467,768,999,324,193,972,18,580,872,363,569,546,647,289,285,250,255,1000,782,329,150,581,959,852,964};
        int[] nums2 = new int[]{131,255,200,378,146,186,413,171,4,879,302,343,740,0,259,974,405,244,736,322,271,87,892,137,903,209,151,362,176,227,133,455,759,601,79,763,381,917,304,4,683,844,461,214,405,772,594,718,588,989,693,38,985,511,263,412,50,901,581,14,265,420,357,89,734,200,997,99,31,832,708,336,646,738,578,215,381,900,791,856,792,548,374,279,787,25,696,682,5,280,146,33,213,660,333,881,534,919,163,760,727,949,455,368,269,747,141,139,214,35,849,450,979,274,970,466,48,774,887,76,25,658,409,520,361,349,249,990,103,79,74,765,227,457,856,228,242,865,426,929,779,591,268,858,895,414,857,561,802,628,305,192,642,858,683,221,467,808,235,436,352,906,375,264,720,986,264,527,445,847,559,746,420,498,999,940,157,166,975,867,120,411,103,486,28,908,518,29,192,337,310,354,120,131,174,799,699,281,70,112,471,380,490,383,519,31,880,596,173,261,420,575,432,171,235,925,24,919,644,226,153,859,602,557,604,163,666,949,606};
        long start = System.nanoTime();
//        List<List<Integer>> result = findDifference(nums1, nums2);
        List<List<Integer>> result = findDifferenceFaster(nums1, nums2);
        long end = System.nanoTime();
        System.out.println(end-start);
        result.forEach(l->{
            System.out.println(l.stream().map(Object::toString).collect(Collectors.joining(","))+"\n");
        });
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> set1NotInSet2 = set1.stream().filter(e->!set2.contains(e)).collect(Collectors.toList());
        List<Integer> set2NotInSet1 = set2.stream().filter(e->!set1.contains(e)).collect(Collectors.toList());
        return Arrays.asList(set1NotInSet2, set2NotInSet1);
    }

    public static List<List<Integer>> findDifferenceFaster(int[] nums1, int[] nums2) {
        Set<Integer> nums1NotInNums2 = new HashSet<>();
        Set<Integer> nums2NotInNums1 = new HashSet<>();
        byte[] nums1found = new byte[252];
        byte[] nums2found = new byte[252];

        for (int j : nums1) {
            if (j>=0) {
                nums1found[126+j/8] |= 1 << j % 8;
            }
            else {
                nums1found[j/8*(-1)] |= 1 << -j % 8;
            }
        }

        for (int k : nums2) {
            if (k>=0){
                nums2found[126+k/8] |= 1 << k % 8;
                if (((nums1found[126+k/8] >> k % 8) & 1) == 0) nums2NotInNums1.add(k);
            }
            else{
                nums2found[k/8*(-1)] |= 1 << -k % 8;
                if (((nums1found[k/8*(-1)] >> -k % 8) & 1) == 0) nums2NotInNums1.add(k);
            }
        }

        for (int j : nums1) {
            if (j>=0){
                if (((nums2found[126+j/8] >> j % 8) & 1) == 0)
                    nums1NotInNums2.add(j);
            }
            else{
                if (((nums2found[j/8*(-1)] >> -j % 8) & 1) == 0)
                    nums1NotInNums2.add(j);
            }
        }
        return Arrays.asList(new ArrayList<>(nums1NotInNums2), new ArrayList<>(nums2NotInNums1));
    }
}
