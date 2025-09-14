/*
    sum of all the integers from 1 to a given number num using recursion.
 */

package com.dsa.lc.recursion;

public class SumOfIntegers {

    public static void main(String[] args){
        System.out.println("sum "+ sum(5));
    }

    public static int sum(int num){

        //base condition - which prevents infinite loop / stackoverflow
        if(num == 1){
            return 1;
        }

        return  num + sum(num-1);

    }

}
