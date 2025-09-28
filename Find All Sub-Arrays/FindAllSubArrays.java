package com.dsa.lc;

public class FindAllSubArrays {

    public static void main(String[] args){
        
        int[] nums = new int[]{1,2,3,4,5};

        for(int i = 0; i < nums.length; i++){     // outer loop starts from 0 to end of the array.
            for(int j = i; j < nums.length; j++){ // middle loop starts from i to end of the array.
                for(int k = i; k <= j; k++){      // inner loop starts from i to j
                    System.out.print(nums[k]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

/*  - Time complexity  - O(n^3) - 3 for loops

    output -
    1 12 123 1234 12345
    2 23 234 2345
    3 34 345
    4 45
    5

 */
