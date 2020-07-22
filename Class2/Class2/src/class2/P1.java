/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class2;

public class P1 {
    public void swap1D(int[] d,int p){
        
        p = p + 1;
        
        if(p < 0 && p >= d.length){
            System.out.println("P >= Arrays");
            return;
        }
        
        int[] left = new int[p];
        for(int i=0; i<left.length;i++){
            left[i] = d[i];
        }
        
        int[] right = new int[d.length - p];
        for(int i=0; i<right.length;i++){
            right[i] = d[i+p];
        }
        
        for(int i=0, j=0;i<d.length;i++){
            if(i < right.length)
                d[i] = right[i];
            else{
                d[i] = left[j];
                j++;
            }
        }
        /*
        for(int i=0, j=0;i<d.length;i++){
            d[i] = d[(d.length-p)+ i];
            //d[i] = left[j++];
         
        }
        */
        
        
    }
}
