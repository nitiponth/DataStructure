package class1;

import static java.lang.Math.abs;
import java.util.Arrays;

public class Class1 {

    public static void main(String[] args) {
        //int[] num = new int[8];
        System.out.println("k > 0");
        int num[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(Arrays.toString(num));
        xArray(num,-2);
        System.out.println(Arrays.toString(num));
        
        System.out.println("---------------------------------- \n k < 0");
        
        int num1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(Arrays.toString(num1));
        xArray(num1,2);
        System.out.println(Arrays.toString(num1));
        
        
    }
    
    public static void xArray (int[] d,int k){
        int size = d.length;
        int[] temp = d.clone();
        if(k >= 0){
            for(int i=0,j=0;i<size;i++){
                if( i+k < size){        //2
                    d[i+k] = temp[i];
                }
                else if(i+k >= size){    // i = 4 , i = 5
                    d[j] = temp[i];
                    j++;
                }
                //System.out.println(Arrays.toString(d));
            } 
        }
        else{
            k = abs(k);
            for(int i=size-1,j=size-1;i>=0;i--){
                if(i-k+1 > 0){
                    d[i-k] = temp[i];
                }
                else{
                    d[j] = temp[i];
                    j--;
                }
                
            }
            //System.out.println(Arrays.toString(d));
        }
        
        
    }   
}
