class Reverse{
  // iterative
  public static LinkedListNode reverse_list(LinkedListNode head) {
    LinkedListNode prev = null;
    LinkedListNode reversed_list = head;
    while (reversed_list != null) {
      LinkedListNode next = reversed_list.next;
      reversed_list.next = prev;
      prev = reversed_list;
      reversed_list = next;
    }
    return prev;
  }
}
