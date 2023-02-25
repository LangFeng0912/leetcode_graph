package LRU;

public class DoubleList {
    Node head, tail;
    int size;

    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addNode(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
        //  node.prev = head;
        //  head.next = node;

    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        //  return node;
    }

    public Node removeHead(){
        Node node = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return node;
    }

    public int getsize(){
        return size;
    }
}
