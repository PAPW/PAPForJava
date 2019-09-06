
class NarcissisticNumber{

/*--------------------  解法一  -----------------------------*/

    public List<Integer> getNarcissisticNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                list.add(i);
            }
            return list;
        }
        int[] digits = new int[n];
        walk(digits, 0, list, 0, 0);
        return list;
    }
    
    //  计算数字第0位时 从1开始遍历到9
    //  计算数字第非0位时，从0遍历到9
    //  分别计算第 i 位的幂以及数字并且进行累加
    private void walk(int[] digits, int i, List<Integer> list, int sum, int value) {
        //这样能节省最少20%运算量
        if(value < sum){
            return;
        }
        //计算出组合的数字以及它的位幂和
        if (i == digits.length) {
            if (sum == value) {
                list.add(value);
            }
        } else {
                for (int j = i==0?1:0; j <= 9; j++) {
                    digits[i] = j;
                    double v = j * Math.pow(10, digits.length - 1 - i);
                    double pow = Math.pow(j, digits.length);
                    value += v;
                    sum += pow;
                    walk(digits, i + 1, list, sum, value);
                    value -= v;
                    sum -= pow;
                }
        }
    }


/*-------------------------  解法二 -----------------------------------*/

    public List<Integer> getNarcissisticNumbers2(int n) {
        List<Integer> ret = new ArrayList<>();
        if(n < 1 || n == 2){
            return ret;
        }else if(n==1){
            ret = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
            return ret;
        }else{
            for(int i = (int)Math.pow(10, n-1); i <= (int)Math.pow(10,n)-1; i++){
                int sum = 0;
                int curr = i;
                while (curr>0){
                    int c = curr%10;
                    sum+=Math.pow(c, n);
                    if(sum>i){
                        break;
                    }
                    curr=curr/10;
                }
                if(sum==i){
                    ret.add(i);
                }
            }
            return ret;
        }
    }

/*--------------------  性能工具  -----------------------------*/

// 将该函数生成的表作为一个全局变量，替代pow函数即可使用.
private int[][] generate_table(int n,int m){
    int [][] ret = new int[n+1][m+1];
    for(int i = 0; i <= n; i++){
        for(int j = 0; j <= m; j++){

            int temp = 1;
            for(int c = 0; c < j; c++){
                temp*=i;
            }
            ret[i][j]+=temp;
//          ret[i][j] = Math.pow(i,j) //该运算比int自乘要慢一点点
        }
    }
    return ret;
}

// 写一个带缓存功能的 pow 函数,需要时计算，不需要时则无需计算
static final int MAX_N = 10;
static final int MAX_M = 10;
static Integer [][] pow = new Integer[MAX_N+1][MAX_M+1];

    // 带缓存的 pow 函数，替代原生的 Math.pow,
    private static int myPow(int n,int m){
        if(pow[n][m] != null)
            return pow[n][m];
        else{
            pow[n][m] = (int)Math.pow(n, m);
            return pow[n][m];
        }
    }

}