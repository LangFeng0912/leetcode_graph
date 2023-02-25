package hash_table;

import java.util.HashMap;

public class RomeInt {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);
        map.put('C',100); map.put('D',500); map.put('M',1000);
        int sum = 0;
        for(int i = 0;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'I'){
                if(i+1 < s.length()){
                    if( s.charAt(i+1)=='V'){
                        sum+=4;
                        i++;
                        continue;
                    }
                    if( s.charAt(i+1)=='X'){
                        sum+=9;
                        i++;
                        continue;
                    }
                }
                sum += 1;
                continue;

            }
            if(ch == 'X'){
                if(i+1 < s.length()){
                    if( s.charAt(i+1)=='L'){
                        sum+=40;
                        i++;
                        continue;
                    }
                    if( s.charAt(i+1)=='C'){
                        sum+=90;
                        i++;
                        continue;
                    }
                }
                sum += 10;
                continue;
            }
            if(ch == 'C'){
                if(i+1 < s.length()){
                    if( s.charAt(i+1)=='D'){
                        sum+=400;
                        i++;
                        continue;
                    }
                    if( s.charAt(i+1)=='M'){
                        sum+=900;
                        i++;
                        continue;
                    }
                }
                sum += 100;
                continue;
            }
            sum += map.get(ch);

        }
        return sum;
    }
}
