package com.liang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L134
 * @description gas-station
 * @Author LiaNg
 * @Date 2018/11/7
 */
public class L134 {


    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        L134 l = new L134();
        System.out.println(l.canCompleteCircuit(gas, cost));
    }

    /**
     * 加油站
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int length = gas.length;

        for (int i=0;i<length;i++) {
            if(cost[i]>gas[i]){
                continue;
            }
            int startGas = gas[i];
            int nowIndex = i;
            for(int j = i;j<length+i;j++){
                startGas = startGas - cost[nowIndex];

                if(startGas<0){
                    break;
                }
                nowIndex = nowIndex + 1;
                if(nowIndex>=length){
                    nowIndex = 0;
                }
                if(nowIndex == i){
                    return i;
                }
                startGas = startGas+gas[nowIndex];
            }
        }

        return -1;
    }
}
