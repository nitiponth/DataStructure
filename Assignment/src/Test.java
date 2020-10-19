import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BinaryHeap bs = new BinaryHeap(5);
        bs.enqueue(7); bs.enqueue(3); bs.enqueue(5); bs.enqueue(1); bs.enqueue(2);
        System.out.println(bs.toString());
        bs.removeDataBHeap(3);
        System.out.println(bs.toString());
        bs.enqueue(13);                  System.out.println(bs.toString());
        System.out.println(bs.dequeue());   System.out.println(bs.toString());
        System.out.println(bs.dequeue());   System.out.println(bs.toString());
        bs.removeDataBHeap(5);           System.out.println(bs.toString());
        bs.removeDataBHeap(10);           System.out.println(bs.toString());







    }
}
