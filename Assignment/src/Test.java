import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        LinkedCollectionWithHeader t = new LinkedCollectionWithHeader();
        t.add("10");
        t.add("1");
        t.add("f");
        t.add("d");
        t.add("e");
        t.add("f");
        System.out.println(t.toString());

        LinkedCollectionWithHeader t1 = new LinkedCollectionWithHeader(t);
        System.out.println(t1.toString());
    }
}
