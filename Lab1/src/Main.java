import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Utils u = new Utils();
        for(int i=0;i<10;i++){
            int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13};
            System.out.println("OG  = : " + Arrays.toString(array));
            u.shuffle(array);
            System.out.println("New = : " + Arrays.toString(array) + "\n");
        }

    }
}
