package class2;

import java.util.Arrays;
import java.util.Random;

public class Class2 {

    public static void main(String[] args) {
        
        System.out.println("------ Summation by each column and row ------\n");
        
        Random rand = new Random();
        //int r = (int) (Math.random()*6-3);
        //int c = (int) (Math.random()*6-3);
        int r = rand.nextInt((9 - 3) + 1) + 3;
        int c = rand.nextInt((9 - 3) + 1) + 3;
        
        int[][] number = new int[r][c];
        for(int i=0;i<number.length;i++){
            for(int j=0;j<number[0].length;j++){
                number[i][j] = rand.nextInt((9 - 0) + 1) + 0;
            }
        }
        
        for(int i=0;i<number.length;i++){
            for(int j=0;j<number[0].length;j++){
                System.out.print(number[i][j] + "   ");
            }
            int sum = 0;
            for(int k=0;k<number[0].length;k++){
                sum = sum + number[i][k];
            }
            System.out.println("|  " + sum +" \n");
        }
        
        System.out.println("\n\n\nmaxIndexColumn   " + maxIndexColumn(number));
        System.out.println("maxIndexRow   " + maxIndexRow(number));
        
        
        int[] test = new int[(rand.nextInt((9 - 0) + 1) + 0)];
        for(int i=0;i<test.length;i++){
            test[i] = rand.nextInt((9 - 0) + 1) + 0;
        }
        System.out.println("\n===============\n");
        System.out.println(Arrays.toString(test));
        P1 p1 = new P1();
        p1.swap1D(test, 3);
        System.out.println(Arrays.toString(test));
        
    }
    
    public static int maxIndexColumn( int[][] d){
       int[] sum = new int[d[0].length];
       int index = -1;
       
       for(int j=0;j<d[0].length;j++){
           for(int i=0;i<d.length;i++){
               sum[j] = sum[j] + d[i][j]; 
           }
       }
       
       int max = 0;
       for(int i = 0;i<sum.length;i++){
           if(max < sum[i]){
               max = sum[i];
               index = i;
           }
       }
       
       for(int i =0;i<sum.length;i++){
           System.out.print("-   ");
       }
            System.out.println("o");
       for(int i =0;i<sum.length;i++){
           System.out.print(sum[i] + "  ");
       }
               
        return index;
    }
    
    public static int maxIndexRow( int[][] d){
       int[] sum = new int[d.length];
       int index = -1;
       
       for(int i=0;i<d.length;i++){
           for(int j=0;j<d[0].length;j++){
               sum[i] = sum[i] + d[i][j]; 
           }
       }
       
       int max = 0;
       for(int i = 0;i<sum.length;i++){
           if(max < sum[i]){
               max = sum[i];
               index = i;
           }
       }
       /*
       for(int i =0;i<sum.length;i++){
           System.out.print(sum[i] + " ");
       }
       */
               
        return index;
    }
    
}

