import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void ordering(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        // add all letters 
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }

        int i = 0;
        while (i != words.length-2) {
            String wordOne = words[i];
            String wordTwo = words[i+1];
            int limit = Math.min(wordOne.length, wordTwo.length);
            for (int j = 0; j < limit; j++) {
                if (wordOne.charAt(j) != wordTwo.charAt(j)) {
                    map.get(wordOne.charAt(j)).add(wordTwo.charAt(j))
                    break;
                }
            }
            i++;
        }


        Set<String> seen = new HashSet<>();
        for (Character c : map.keySet()) {
            if (!seen.contains(c)) {
                dfs(seen, c, map);
            }
        }
        // now we count, and then add them as we go forward, easy clapppp 
        // transfer mapping to change hashsets to counts
        // make seen and map static because of how we're passsing it all the time 
    }

    public void dfs(Set<Character> seen, Character c, HashMap<Character, HashSet<Character>> map) {
        if(seen.contains(c)) return;
        seen.add(c);
        for(Character curr : map.get(c)){
            dfs(seen, curr,  map);
            map.get(c).addAll(map.get(curr));
        }
        return;
    }
}