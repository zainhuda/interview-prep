class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while (x>1) {
            // slow
            x = cal(x) ;
            if(x == 1) return true;
            // fast
            y = cal(cal(y));
            if(y == 1) return true;

            if(x == y) return false;
        }
        return true ;
    }

    public int cal(int n){
        int x = n;
        int s = 0;
        while (x>0) {
            s = s + (x%10)*(x%10);
            x = x/10;
        }
        return s;
    }
}
