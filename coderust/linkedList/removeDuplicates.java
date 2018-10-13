class removeDuplicate{
  public static LinkedListNode remove_duplicates(LinkedListNode head) {
    Set<Integer> store = new HashSet<>();
    LinkedListNode node = head, prev = null;
    while(node != null) {
      if (store.contains(node.data)) {
        prev.next = node.next;
        node = node.next;
        continue;
      }
      store.add(node.data);
      prev = node;
      node = node.next;
    }
    return head;
  }
}
