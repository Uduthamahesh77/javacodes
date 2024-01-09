import java.util.*;
import java.lang.*;
public class Array {

    // A function to find maximum sum of a sub array in brute force method.................................................................
    public static int Subarray(int array[]){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                int currentSum=0;
                for(int k=i;k<=j;k++){
                    currentSum+=array[k];
                }
                if(currentSum>maxSum){
                    maxSum=currentSum;
                }
            }
        }
        return maxSum;
    }
// a program to calculate maxsum of a sub array in O(n*2)................................................................................
    public static int prefixsum(int nums[]){
        int sum=0;
        int max=Integer.MIN_VALUE;
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                sum=i==0?prefix[j]:prefix[j]-prefix[i-1];
                if(max<sum){
                    max=sum;
                }
            }
        }
        return max;
    }
// a program to calculate maxsum of a sub array in O(n).................................................................................
    public static int kadanssum(int array[]){
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            currentSum+=array[i];
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
            if(currentSum<0){
                currentSum=0;
            }
        }
        return currentSum;
    }
// a program to print pairs of a array ...............................................................................................
    public static void printsubarrays(int array[]){
         for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(array[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int array[]={1,-2,6,-1,3};
        System.out.println(kadanssum(array));
    }
}
