import java.util.LinkedList;

class Solution {
    // we can have a linkedlist
    // where each node holds array of size ArraySize
	// all O(1) time
	
    LinkedList<int[]> queue;
    int arraySize;
    // We use these variables to make removal of element easy, helps us not have to shift elements when we remove
    int rear;
    int start;
    public Solution(int arraySize) {
    	if (arraySize <= 0) throw new IllegalArgumentException("Invalid array size!");
        this.queue = new LinkedList<int[]>();
        this.queue.add(new int[arraySize]);
        this.arraySize = arraySize;
        this.rear = 0;
        this.start = 0;
    }

    public void enqueue(int value) {
        if (rear <= arraySize-1) {
            // We can place this into the end of list
            queue.getLast()[rear] = value;
            rear++;
        } else {
            // add value new array to the linkedlist
            int[] curr = new int[arraySize];
            curr[0] = value;
            rear = 1;
            queue.offer(curr);
        }
    }

    public int poll() {
        // returns the head of the queue
        if (queue.isEmpty()) return -1;
        int ret = queue.getFirst()[start];
        start++;
        if (start >= arraySize) {
        	queue.removeFirst();
        	start  = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution testQ = new Solution(1);
        for (int i = 1; i < 3; i++) {
            testQ.enqueue(i);
        }
        for (int i = 1; i < 2; i++) {
            System.out.println(testQ.poll());
        }
    }
}