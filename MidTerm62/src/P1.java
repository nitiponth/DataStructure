import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class P1 {

    public int secondMax(int[] d){
        int max = -1;
        int max2 = -1;
        if(d.length<2)
            return max2;
        for(int j=0;j<d.length;j++){
            if(max < d[j]) {
                max2 = max;
                max = d[j];
            }
        }
        return max2;
    }

    public void p1d2(){
        int i,j,c,r;
        int[] a = new int[10];
        a[0] = 0; a[1] = 1; a[2] = 2; r = 3;
        for(i=2;i<10;i++){
            c = a[i];
            System.out.println("c =: " + c);
            for(j=0;j<c && r<10;j++) {
                a[r++] = i;
                System.out.println("a =: " + Arrays.toString(a));
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public  void p4(){
        ArrayList list = new ArrayList(10);
        list.add("A"); list.add("B"); list.add(2,"C"); list.add(1,"D");
        list.add("E"); list.remove(2); list.set(1,list.get(3));
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i) + " ");
        }
    }

}
