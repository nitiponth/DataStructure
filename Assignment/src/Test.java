import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        BSTree bt = new BSTree();
        bt.add(5); bt.add(3); bt.add(1); bt.add(2);
        bt.add(6); bt.add(8); bt.add(7); //bt.add(4);
        Object[] obj = bt.toArray();
        System.out.println(Arrays.toString(obj));
        System.out.println(bt.count(100));








    }
}
