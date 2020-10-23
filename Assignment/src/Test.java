import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        ArrayQueue q = new ArrayQueue(5);
        q.enqueue("A"); q.enqueue("B"); q.enqueue("C"); q.enqueue("D");
        q.enqueue("E"); q.enqueue("F"); q.enqueue("I"); q.enqueue("J");
        System.out.println(q.toString());

        Object[] t = q.test(3);
        System.out.println(Arrays.toString(t));
        System.out.println(t.length);







    }
}
