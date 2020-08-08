import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        P1 p = new P1();
        //p.p1d2();

        int[] sMax = {4};
        System.out.println(Arrays.toString(sMax));
        System.out.println(p.secondMax(sMax));

        //p.p4();

        System.out.println("===================== 4.2 ======================");

        ArrayList c = new ArrayList(5);
        c.add("B"); c.add("A"); c.add("C");

        ArrayList al = new ArrayList(10);
        al.add("A"); al.add("A"); al.add("C"); al.add("B"); al.add("C");

        System.out.print("al=: ");
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i) + " ");
        }
        System.out.print("\nC=: ");
        for(int i=0;i<c.size();i++) {
            System.out.print(c.get(i) + " ");
        }

        for(int i=0; i<al.size();i++){
                if(!c.contains(al.get(i))) {
                    al.set(i,"thIs");
                }
        }
        while (al.contains("thIs")){
            al.remove("thIs");
        }

        System.out.print("\n\nal=: ");
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i) + " ");
        }
        System.out.print("\nC=: ");
        for(int i=0;i<c.size();i++){
            System.out.print(c.get(i) + " ");
        }

        System.out.println("\n===================== End ======================");
    }
}
