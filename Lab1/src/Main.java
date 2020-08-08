//Create by Nitipon Thoophom 6203051613034 EnET
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Utils u = new Utils();
        int[] array1 = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(int i=0;i<13;i++){
            //System.out.println("OG  = : " + Arrays.toString(array1));
            u.shuffle(array1);
            //System.out.println("New = : " + Arrays.toString(array1) + "\n");
        }

        int[] array2 = {12,6,7,4,8,34,59,28};
        //System.out.println("OG  = : " + Arrays.toString(array2));
        u.remove(array2,3);
        //System.out.println("NW  = : " + Arrays.toString(array2));

        int[] array3 = {34,12,59,4,8,34,59,28};
        //System.out.println("OG  = : " + Arrays.toString(array3));
        u.insert(array3,1, 79);
        //System.out.println("NW  = : " + Arrays.toString(array3));

        double[][] array4 = {{1,0,0,0},{1,4,0,0},{2,1,2,0},{7,5,5,3}};
        System.out.println(u.isLowerTriangular(array4));

        int[] array5 = {1,10,2,0,13,14,99,3,4,5};
        System.out.println("OG  = : " + Arrays.toString(array5));
        System.out.println("NW  = : " + Arrays.toString(u.maxmin(array5)));

    }
}
