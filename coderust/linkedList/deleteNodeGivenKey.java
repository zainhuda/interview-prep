class deleteNode{
  public static LinkedListNode delete_node(LinkedListNode head, int key) {
    LinkedListNode node = head, prev = null;
    while (node != null) {
      if (node.data == key && prev == null) {
        head = node.next;
        node = node.next;
        continue;
      }
      if (node.data == key && prev != null) {
        prev.next = node.next;
        node = node.next;
        continue;
      }
      prev = node;
      node = node.next;
    }
    return head;
  }
}
