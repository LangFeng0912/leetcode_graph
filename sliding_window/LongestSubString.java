package sliding_window;

import java.util.HashSet;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        int l = 0,r = 0;
        HashSet<Character> set = new HashSet<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            while(r<s.length() && !set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
                // ch = s.charAt(r);
            }
            int cur_l = set.size();
            maxL = Math.max(maxL,cur_l);
            if(r == s.length()){
                return maxL;
            }

            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }

        }
        return maxL;
    }
}
