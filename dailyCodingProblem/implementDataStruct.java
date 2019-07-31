/**
 * Asked by TripleByte
 * Implement a data structure that carries out the following operations
 * without rezising the underlying array
 * add(value): add a value to the set of values
 * check(values): check whether a value is in the set 
 */

 class Solution {
    // no remove operation so we don't need to take care of that
    // using standard library functions is most likely not allowed
    // we can store n elements without having to resize array
    // once n elements are stored, we can remove the values starting from 0, idk if we can do this

    int[] store = new int[100];
    int pointer  = 0;
    public void add(int value) {
        if (this.pointer > store.length) {
            this.pointer = 0;
        }
        this.store[this.pointer] = value;
        this.pointer++;
    }

    public boolean check(int value) {
        for (int n: this.store) {
            if (n == value) {
                return true;
            }
        }
        return false;
    }
 }