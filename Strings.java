import java.util.*;
import java.lang.*;
public class Strings {
// a program to covert a roman to integer..........................................................................
   public static int roman(String s){
    Map<Character,Integer>map=new HashMap<>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('M',1000);
    map.put('D',500);
    int ans=0;
    for(int i=0;i<s.length();i++){
        if(i<s.length()-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
            ans-=map.get(s.charAt(i));
        }else{
            ans+=map.get(s.charAt(i));
        }
    }
    return ans;
   }
// a program to find the larget palindrome in a sub string.........................................................
    public static boolean solve(String s,int i,int j){
        if(i>=j){
            return true;
        }
        if(s.charAt(i)==s.charAt(j)){
            return solve(s,i+1,j-1);
        }
        return false;
    }
    public static String isPalindrome(String s){
        int maxlength=Integer.MIN_VALUE;
        int startpoint=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j)==true){
                    if(j-i+1>maxlength){
                        maxlength=j-i+1;
                        startpoint=i;
                    }
                }
            }
        }
        return s.substring(startpoint,startpoint+maxlength);
    }
    public static void main(String[] args) {
        String s="ababagagf";
        String v="MCMXCIV";
        System.out.print(roman(v));
    }
}
