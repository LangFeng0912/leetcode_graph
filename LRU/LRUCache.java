package LRU;

import java.util.HashMap;

//双向链表 + 哈希表
// 链表结构 node<key,val> ->/<- node<key,value>
// 哈希表结构 <key,Node>
public class LRUCache {
    HashMap<Integer, Node> map ;
    int size;
    DoubleList dl;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        dl = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            dl.removeNode(node);
            dl.addNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            dl.removeNode(node);
            node.value = value;
            map.put(key,node);
            dl.addNode(node);
        }else{
            if(dl.getsize()<size){
                Node node = new Node(key,value);
                dl.addNode(node);
                map.put(key,node);
            }else{
                Node old = dl.removeHead();
                map.remove(old.key);
                Node node = new Node(key,value);
                dl.addNode(node);
                map.put(key,node);
            }
        }
    }
}
