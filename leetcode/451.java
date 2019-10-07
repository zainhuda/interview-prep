class Solution {
    public String frequencySort(String s) {
        // using a heap
        // max heap
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                if (map.get(c2) == map.get(c1)) {
                    return c2.compareTo(c1);   
                }
                return map.get(c2) - map.get(c1);
            }
        });
        
        for (char c : map.keySet()) {
            heap.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        // Building string
        while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}