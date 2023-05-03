package leetcode.roman;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        String s = "III"; // 18]
        System.out.println(romanToInt(s));
        int sum = 0;
        List<Integer> rezult = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i+1);
            rezult.add(map.get(sub));
        }

        for (int i = 0; i < rezult.size(); i++) {
            if (i+1 < rezult.size() && rezult.get(i+1) > rezult.get(i)){
                sum += rezult.get(i+1) - rezult.get(i);
                i++;
            }
            else{
                sum += rezult.get(i);
            }
        }
        System.out.println(sum);
    }
    public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}

