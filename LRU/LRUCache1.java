package LRU;

import java.util.LinkedHashMap;

public class LRUCache1 {
    int size;
    LinkedHashMap<Integer, Integer> map;
    public LRUCache1(int capacity) {
        this.size = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            int val = map.get(key);
            map.remove(key);
            map.put(key,val);
            // size ++;
            return val;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }else{
            if(map.size()<size){
                map.put(key,value);
            }else{
                //获取linkedhashmap第一个元素
                // map.keySet().iterator().next()
                map.remove(map.keySet().iterator().next());
                map.put(key,value);
            }
        }
    }
}
