package LRU;

public class Node {
    public int key,value;
    public Node prev,next;
    public Node(int k,int v){
        this.key = k ;
        this.value = v;
    }
}
