package hash_table;

import java.util.HashSet;

public class max_subString {
    public int lengthOfLongestSubstring(String s) {
        // HashSet<Character> set = new HashSet<>();
        if(s.length() == 0) return 0;
        int slow = 0;
        int fast = slow;
        int maxL = Integer.MIN_VALUE;
        while(slow<s.length()){
            HashSet<Character> set = new HashSet<>();
            fast = slow;
            while(fast<s.length() && !set.contains(s.charAt(fast))){
                set.add(s.charAt(fast));
                fast++;
            }
            // System.out.println(set.size());
            maxL = Math.max(maxL,set.size());
            slow++;
        }
        return maxL;
    }
}
