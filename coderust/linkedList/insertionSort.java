class InsertionSort{
   public static LinkedListNode insertion_sort(LinkedListNode head) {
      LinkedListNode sortedLL = null;
      LinkedListNode node = head;
      while (node != null) {
        LinkedListNode temp = node.next;
        sortedLL = insertionHelper(sortedLL, node);
        node = temp;
      }
      return sortedLL;
    }
    public static LinkedListNode insertionHelper(LinkedListNode head, LinkedListNode node) {
      // no node
      if (node == null) {
        return head;
      }
      // if smallest
      if (head == null || node.data <= head.data) {
        node.next = head;
        return node;
      }
      // finding spot
      LinkedListNode current = head;
      while (current.next != null && current.next.data < node.data) {
        current = current.next;
      }
      node.next = current.next;
      current.next = node;
      return head;
    }
}
