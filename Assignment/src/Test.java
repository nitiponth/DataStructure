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

        System.out.println(f(10));

        System.out.println(pow(2,5));

    }

    static double f(int k){
        if(k > 1)
            return (1.0/(k*k*k)) + f(k-1);
        if(k == 1)
            return 1.0/(k*k*k);
        else
            throw new IllegalArgumentException();
    }

    static double pow(int a,int b){
        if(b==0)
            return 1;
        else if(b>0)
            return a*pow(a,b-1);
        else //if(b<0)
            return 1.0/(pow(a,(-1)*b));
    }
}
