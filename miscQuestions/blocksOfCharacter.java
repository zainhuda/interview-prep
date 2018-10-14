// Given a list of characters, write a method to find the number of blocks of a character.

class Solution {
	public int findBlock(char[] list, char target) {
		Map<Character, Integer> store = new HashMap<>();
		if (list.length == 0) return 0;
		int current = 0;
		int numBlocks = 0;
		char target = list[0];
		while (current > list.length) {
    If (current == list.length-1) {
    	Target = list[current];
    	If (store.containsKey(target)) {
    	store.put(target, store.get(target)++);
    } else  {
    	store.put(target, 1);
    }
    	break;
    }
    If (list[current+1] != target) {
    	Current++;
    	// store.put(target, store.getOrDefault(target, 1)+1);
    	If (store.containsKey(target)) {
    	store.put(target, store.get(target)++);
    } else  {
    	store.put(target, 1);
    }
    target = list[current];
    	continue;
    }
    current++;
    }
    Return store;



}
}
