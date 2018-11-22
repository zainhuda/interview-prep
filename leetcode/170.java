class TwoSum {

    List<Integer> store;
    HashSet<Integer> difference;

    /** Initialize your data structure here. */
    public TwoSum() {
        store = new ArrayList<>();
        difference = new HashSet<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        store.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        difference.clear();
        for (int i = 0; i < store.size(); i++) {
            if (difference.contains(store.get(i))) {
                return true;
            }
            difference.add(value-store.get(i));
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
