class queue_using_stack{
    //TODO: Write - Your - Code
    Stack<Integer> s1 = new Stack<>();
    // aux stack
    Stack<Integer> s2 = new Stack<>();
    // O(1)
    void enqueue(int data) {
      s1.push(data);
    }

    boolean isEmpty() {
      return s1.isEmpty();
      //return false;
    }

    // O(n)
    int dequeue() throws Exception {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
      int ret = s2.pop(); 
      
      while (!s2.isEmpty()) {
        s1.push(s2.pop());
      }
      
      return ret;
    }
}  