//determine if a string contains all unique characters

// using additional  data structure?
public class Solution {
  // worst case runs in O(n)
  boolean isUnique(String input) {
    Stack stack = new ArrayList();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (stack.contains(c)) {
        return false;
      } else {
        stack.push(c);
      }
    }
    return true;
  }

  // worst case runs in O(n^2)
  boolean isUnique(String input) {
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      for (int j = i+1; j < input.length(); j++) {
        char b = input.charAt(j);
        if (c == b) {
          return false;
        }
      }
    }
    return true;
  }
}
