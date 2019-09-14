

class DigitCounts{

    /*-----  解法一 ----------*/
    public int digitCounts(int k, int n) {
        int ret = n/10+(n%10<k?0:1);
        int carry = 10;
        int low = n%carry;
        int hig = n/carry;

        while(hig > 0){
            ret += (hig/10*carry) - (k==0?carry:0) + (hig%10==k?(low+1):(hig%10>k?carry:0));
            carry *= 10;
            hig = n/carry;
            low = n%carry;
        }
        return ret;
    }
}