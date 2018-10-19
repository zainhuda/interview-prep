class LRUCache {
  int capacity;

  //LinkedListNode holds key and value pairs
  HashMap<Integer,LinkedListNode> cache;
  LinkedList<LinkedListNode> cache_vals;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<Integer,LinkedListNode>(capacity);
    cache_vals = new LinkedList<LinkedListNode>();
  }

  // both getting and setting change the next in line to be
  // evicted from the cache
  // linkedlist keeps track of order
  // hashmap keeps track of key and its node
  int get(int key) {
    // check if it exists, if so we retrieve it
    // and push it to the end of the list
    // 2 - 3 - 4 - 5
    // find 2
    // 3 - 4 - 5 - 2
    LinkedListNode get = cache.get(key);
    if (get != null) {
      cache_vals.remove(get);
      cache_vals.addLast(get);
      return get.data;
    }
    return -1;
  }

  void set(int key, int value) {
    LinkedListNode get = cache.get(key);
    if (get == null) {
      // check if capacity is full
      if (capacity <= cache_vals.size()) {
        LinkedListNode removed = cache_vals.removeFirst();
        cache.remove(removed.key);
      }
      LinkedListNode newNode = new LinkedListNode(key, value);
      cache_vals.addLast(newNode);
      cache.put(key, newNode);
    } else {
      cache_vals.remove(get);
      cache_vals.addLast(get);
    }
  }

  String print() {
    String result = "";
    ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
    while(iterator.hasNext()){
      LinkedListNode node = iterator.next();
      result += "("+node.key + ":" +node.data+")" + ",";
    }
   return result;
  }
}
