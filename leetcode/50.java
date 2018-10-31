class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            n = -n;
            x = 1/x;
            n--;
            result = x;
        }
        for (int i = n; i != 0; i=i/2) {
            if (i % 2 == 1) result *= x;
            x *= x;
        }
        return result;
    }
}
