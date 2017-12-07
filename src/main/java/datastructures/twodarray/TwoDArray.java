package datastructures.twodarray;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


//COMPLETED!
public class TwoDArray {

    //1. Identify the shape of an hour glass
    //2. Iterate through each row of the list
    //2. Sum the hour glass
    //keep a counting pass if the new sum is greater than the old

    public static int iterator(int [][] multiArr) {
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < multiArr.length; i++) {
            for(int j = 0; j < multiArr[i].length; j++) {
                int hourglassSum = identifyHourGlassShape(i,j, multiArr);
                if(hourglassSum > sum) {
                    sum = hourglassSum;
                }
            }
        }
        return sum;
    }

    /**
     * Identifys the shape of the hourglass
     */
    public static int identifyHourGlassShape(int xStart, int yStart, int [][] multiArr) {
        if(xStart > (multiArr.length) - 3 || yStart > (multiArr[0].length) - 3) {
            return Integer.MIN_VALUE;
        }
        int a = multiArr[xStart][yStart];
        int b = multiArr[xStart][yStart + 1];
        int c = multiArr[xStart][yStart + 2];
        int d = multiArr[xStart + 1][yStart + 1];
        int e = multiArr[xStart + 2][yStart];
        int f = multiArr[xStart + 2][yStart  + 1];
        int g = multiArr[xStart + 2][yStart + 2];
        return (a + b + c + d + e + f + g);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int largestSum = iterator(arr);
        System.out.println(largestSum);
    }
}