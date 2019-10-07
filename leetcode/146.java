class LRUCache {
    // hashmap holds integer, and node h value held
    class TreeNode {
        TreeNode next;
        TreeNode prev;
        int key;
        int val;
        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, TreeNode> map;
    TreeNode head, tail;
    int capacity;
    int size;
    // need a remove method
    // and we keep track of head and tail
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new TreeNode(-1, -1);
        this.tail = new TreeNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        TreeNode ret = map.get(key);
        // Remove node
        remove(ret);
        // Add to head of list, update
        update(ret);
        // Return val
        return ret.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            TreeNode ret = map.get(key);
            ret.val = value;
            remove(ret);
            update(ret);
            return;
        }
        if (size == capacity) {
            // need to remove
            TreeNode removeNode = popTail();
            map.remove(removeNode.key);
            size--;
        }
        size++;
        TreeNode node = new TreeNode(key, value);
        map.put(key, node);
        update(node);
    }
    
    public TreeNode popTail() {
        TreeNode node = tail.prev;
        remove(node);
        return node;
    }
    public void update(TreeNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    public void remove(TreeNode node) {
        TreeNode temp = node.prev;
        node.prev.next = node.next;
        node.next.prev = temp;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */