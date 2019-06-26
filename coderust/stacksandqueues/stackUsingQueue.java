class stack_using_queue{
    //TODO: Write - Your - Code
     Queue<Integer> q1 = new LinkedList<>();
     Queue<Integer> q2 = new LinkedList<>();
     void push(int data) {
       q1.add(data);
     }
   
     boolean isEmpty() {
       return q1.isEmpty() || q2.isEmpty();
     }
 
     int pop() throws Exception {
       int size = q1.size();
       while (size > 1) {
         q2.add(q1.remove());
         size--;
       }
 
       return q1.remove();
   }
 }