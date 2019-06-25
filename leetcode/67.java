class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int c = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            sum = c;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            res.append(sum % 2);
            c = sum / 2;
            i--;
            j--;
        }
        
        if (c != 0) res.append(c);
        return res.reverse().toString();
    }
}