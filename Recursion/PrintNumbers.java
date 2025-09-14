/*
    print numbers from 1 to given num in ascending or descending order using recursion.
 */
package com.dsa.lc.recursion;

public class PrintNumbers {

    public static void main(String[] args){
        printNumber(5);
    }

    public static void printNumber(int num){

        //base condition
        if(num == 1){
            System.out.println(num);
            return ;
        }

        //System.out.println(num); // print numbers in descending order
        printNumber(num - 1);
        System.out.println(num); // print numbers in ascending order
    }
}
