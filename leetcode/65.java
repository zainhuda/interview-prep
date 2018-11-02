class Solution {
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        boolean eSeen = false;
        boolean numSeen = false;
        boolean eAfter = false;
        boolean pointSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current >= '0' && current <= '9') {
                if (!eSeen) numSeen = true;
                if (eSeen) eAfter = true;
            } else if (current == '-' || current == '+') {
                if (i != 0 && s.charAt(i-1) != 'e') return false;
            } else if (current == 'e') {
                if (eSeen) return false;
                eSeen = true;
            } else if (current == '.') {
                if (pointSeen || eSeen) return false;
                pointSeen = true;
            } else {
                return false;
            }
        }
        return eSeen ? (numSeen && eAfter) : numSeen;
    }
}
