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
// a program calculating trappimg rain water..............................................................................................
    public static int Trappingwater(int height[]){
        int n=height.length;
        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        int rightmax[]=new int[n];
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i]);
        }
        int trappingwater=0;
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(leftmax[i],rightmax[i]);
            trappingwater+=waterlevel-height[i];
        }
        return trappingwater;
    }
// added a program of container with max water.....................................................................................
    public static int maxwater(int height[]){
        int n=height.length;
        int i=0,j=n-1;
        int maxwater=0;
        while(i<j){
            int water=Math.min(height[i],height[j])*(j-1);
            maxwater=Math.max(water,maxwater);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxwater;
    }


    public static void main(String[] args) {
        int array[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxwater(array));
    }
}
