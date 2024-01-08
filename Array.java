import java.util.*;
import java.lang.*;
public class Array {
    public static void main(String[] args) {
        int array[]={1,2,3,4,5,6};
        int x=0;
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
            x=Math.max(x,array[i]);
        }
        System.out.println();
        System.out.println(x);
        
    }
}
