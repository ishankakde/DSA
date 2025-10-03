/*
Reverse an Array

logic -
    - Two pointer approach
    - swap elements at start and end index
    - move start forward and end backwards
    - while(start < end) works for both odd and even length arrays.
    - for odd length the middle element does not get swapped as it remains at same position after reversal.
*/

package com.dsa.lc;

public class ReverseAnArray {

    public static void main(String[] args) {

        int[] even = new int[]{1,2,3,4,5,6,7,8};
        int[] odd = new int[]{1,2,3,4,5,6,7,8,9};
        reverse(even);
        reverse(odd);

    }

    public static void reverse(int nums[]) {

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
        System.out.println();
    }
}
