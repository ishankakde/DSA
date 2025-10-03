/*
Reverse an Array
*/

package com.dsa.lc;

public class ReverseAnArray {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};

        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }

        for(int num : nums){
            System.out.print(num +" ");
        }
    }
}


