
package org.pap;
import java.util.*;

public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        Queue<Long> table = new PriorityQueue<>();
        table.add(1L);
        int[] factor = {2,3,5};
        for(int i = 1; i < n;i++){
            Long num = table.poll();
            for(int j : factor){
                if(!table.contains(j*num))
                    table.add(j*num);
            }
        }
        return table.poll().intValue();
    }

}