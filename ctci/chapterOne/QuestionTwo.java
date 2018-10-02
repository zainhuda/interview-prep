public class Solution {
  boolean permutationCheck(String a, String b) {
    if (a.length() != b.length()) return false;
    Stack stack = new ArrayList();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      stack.push(c);
    }
    //check b is a
    for (int i = 0; i < b.length; i++) {
      char c = b.charAt(i);
      if (!stack.contains(c)) {
        return false;
      }
    }
    return true;
  }
}
