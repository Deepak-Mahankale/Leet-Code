class Solution {
    public int reverse(int x) {
        long revernum = 0;
        while (x > 0) {
            int lastd = x % 10;
            revernum = (revernum * 10) + lastd;
            x = x / 10;
        }
        while (x < 0) {
            int lastd = x % 10;
            revernum = (revernum * 10) + lastd;
            x = x / 10;
        }
        if (revernum <= -Math.pow(2, 31) || revernum >= Math.pow(2, 31) - 1) {
            revernum = 0;
        }
        return (int) revernum;
    }
}