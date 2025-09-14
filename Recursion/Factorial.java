/*
    find factorial of number using recursion
 */
package com.dsa.lc.recursion;

public class Factorial {

    public static void main(String[] args){
        int num = 5;
        System.out.println("factorial of "+num+" is - "+ factorial(num));
    }

    public static int  factorial(int num) {
        if(num == 1){
            return num;
        }
        return num * factorial(num - 1);
    }


}
