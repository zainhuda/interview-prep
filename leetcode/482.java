class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String S1 = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S1);
        int length = sb.length();
        System.out.println(sb.length());
        for (int i = K; i < length; i+=K) {
            sb.insert(length-i, "-");
        }
        return sb.toString();
    }
}
