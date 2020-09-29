import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        //s.push("A"); s.push("A"); s.push("A"); s.push("B"); s.push("B"); s.push("F"); s.push("F");
        //s.push("D"); s.push("E"); s.push("F"); s.push("C"); s.push("D"); s.push("B"); s.push("B");
        //s.push("A");s.push("F"); s.push("E"); s.push("F");
        //System.out.println(s.toString());
        //s.reverseStacK();
        //System.out.println(s.toString());

        s.push("A"); s.push("V"); s.push("K"); s.push("C"); s.push("D"); s.push("J"); s.push("Z");
        //s.push("F"); s.push("E"); s.push("Y");
        System.out.println(s.toString());
        s.moveToTopOfStack(2);
        System.out.println(s.toString());

    }
}
