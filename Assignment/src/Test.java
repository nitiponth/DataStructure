import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList t = new ArrayList(100);
        t.add("A"); t.add("B"); t.add("C"); t.add("D"); t.add("1"); t.add("2"); t.add("3"); t.add("4");
        System.out.println(t.toString());
        t.reverse();
        System.out.println(t.toString());
        t.addInBound(3,"J");
        System.out.println(t.toString());
        ArrayList t1 = new ArrayList(100);
        t1.add("Y"); t1.add("O"); t1.add("U");
        System.out.println(t.toString());
        t.removeRange(0,5);
        System.out.println(t.toString());

        t.addRange(t1,0);
        System.out.println(t.toString());

    }
}
