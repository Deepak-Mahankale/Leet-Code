class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int k = x;
        if (x < 0) {
            return false;
        } else {
            while (x != 0) {
                int lastd = x % 10;
                rev = rev * 10 + lastd;
                x = x / 10;
            }
            if (rev == k) {
                return true;
            } else {
                return false;
            }

        }
    }
}