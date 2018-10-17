class removeDuplicate{
  public static ListNode deleteDuplicates(ListNode head) {
    Set<Integer> store = new HashSet<>();
    ListNode node = head, prev = null;
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
