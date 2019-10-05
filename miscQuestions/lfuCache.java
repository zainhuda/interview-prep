import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int count;
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }
    class LList {
        Node head;
        Node tail;
        int size;
        public LList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void remove(Node node) {
            size--;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeTail() {
            if (size <= 0) return null;
            Node temp = tail.prev;
            remove(temp);
            return temp;
        }

        public void add(Node node) {
        	head.next.prev = node;
        	node.next = head.next;
        	head.next = node;
        	node.prev = head;
            size++;
        }
    }
    // Hashmap, Frequency -- Linkedlist (of nodes that have that frequency)
    // Hashmap, Key, frequency
    Map<Integer, Node> cache;
    Map<Integer, LList> frequency;
    int minFreq;
    int numElements;
    int capacity;
    public LFUCache(int capacity) {
        numElements = 0;
        minFreq = 1;
        this.capacity = capacity;
        frequency = new HashMap<>();
        cache = new HashMap<>();
    }

    public int get(int key)  {
    	if (!cache.containsKey(key)) return -1;
       Node node = cache.get(key);
       if (node == null) return -1;
       LList toUpdate = frequency.get(node.count);
       toUpdate.remove(node);
       if (node.count == minFreq && toUpdate.size == 0) minFreq++;
       node.count++;
       LList list = frequency.getOrDefault(node.count, new LList());
       list.add(node);
       frequency.put(node.count, list);
       return node.value;
    }

    public void put(int key, int value) {
        // do the operations here 
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            LList toUpdate = frequency.get(node.count);
            toUpdate.remove(node);
            if (node.count == minFreq && toUpdate.size == 0) minFreq++;
            node.count++;
            LList list = frequency.getOrDefault(node.count, new LList());
            list.add(node);
            frequency.put(node.count, list);
        } else {
            Node node = new Node(key, value);
            if (capacity == numElements) {
                Node temp = frequency.get(minFreq).removeTail();
                cache.remove(temp.key);
                numElements--;
            }
            numElements++;
            cache.put(key, node);
            LList toAdd = frequency.getOrDefault(1, new LList());
            toAdd.add(node);
            frequency.put(node.count, toAdd);
            minFreq = 1;
        }

    }
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}