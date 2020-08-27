
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
//        LinkedCollection a = new LinkedCollection();
//        LinkedCollection b = new LinkedCollection();
//        a.add("A");
//        a.add("B");
//        a.add("C");
//        b.add("D");
//        b.add("E");
//        b.add("F");
//        
//        System.out.print(a.xDiff(b));

        ArrayList ar = new ArrayList(100);
        ar.add("A");
        ar.add(0,"B");
        ar.add("C");
        ar.add("D");
        ar.add("E");
        ar.add("F");
        System.out.println(ar.toString());
        ar.removeRange(2, 4);
        System.out.println(ar.toString());

    }
}
