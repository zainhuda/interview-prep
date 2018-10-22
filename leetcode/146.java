class LRUCache {
    class LinkedNode {
      int key;
      int value;
      LinkedNode prev;
      LinkedNode next;
    }

    void addNode(LinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    void removeNode(LinkedNode node) {
        LinkedNode previous = node.prev;
        LinkedNode next = node.next;
        previous.next = next;
        next.prev = previous;
    }

    void moveHead(LinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    LinkedNode popTail() {
        LinkedNode last = tail.prev;
        this.removeNode(last);
        return last;
    }

    int capacity;
    int count; // amount in cache

    //LinkedListNode holds key and value pairs
    HashMap<Integer,LinkedNode> cache;
    LinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        cache = new HashMap<Integer,LinkedNode>(capacity);
        // LL initalizae
        head = new LinkedNode();
        head.prev = null;
        tail = new LinkedNode();
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        // check if it exists, if so we retrieve it
        // and push it to the end of the list
        // 2 - 3 - 4 - 5
        // find 2
        // 3 - 4 - 5 - 2
        LinkedNode get = cache.get(key);
        if (get != null) {
            this.moveHead(get);
            return get.value;
        }
        return -1;
    }

    void put(int key, int value) {
        LinkedNode get = cache.get(key);
        if (get == null) {
          // check if capacity is full
          if (capacity <= count) {
            LinkedNode removed = this.popTail();
            cache.remove(removed.key);
            --count;
          }
          count++;
          LinkedNode newNode = new LinkedNode();
          newNode.key = key;
          newNode.value = value;
          this.addNode(newNode);
          cache.put(key, newNode);
        } else {
          get.value = value;
          this.moveHead(get);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
