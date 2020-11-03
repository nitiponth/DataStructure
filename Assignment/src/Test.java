import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        ArrayStack as = new ArrayStack();
        as.push("A"); as.push("A"); as.push("A"); as.push("F");
        //as.push("E"); as.push("D"); as.push("C"); as.push("B");

        Object[] obj = as.multiPopE(0,"B");
        //System.out.println(Arrays.toString(obj));
        //System.out.println(obj.length);

        //System.out.println(fun(1));

        System.out.println("1+1 = " + "1"+"1");     //This line
        System.out.println(myLife(6,5));

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(arr));

        System.out.println(goo(3));

        ArrayStack as2 = new ArrayStack();
        //as2.push("E"); as2.push("D"); as2.push("C"); as2.push("B");
        System.out.println(as.toString());
        System.out.println(as2.toString());
        as.setReverse(as2);
        System.out.println(as.toString());

        ArrayQueue q = new ArrayQueue(1);
        q.enqueue("A"); q.enqueue("A"); q.enqueue("A"); q.enqueue("B"); q.enqueue("B");
        q.enqueue("F"); q.enqueue("F"); q.enqueue("F"); q.enqueue("Z");
        System.out.println(q.getK(0));

    }

    public static int goo(int a){
        if( a < 2)
            return a;
        return goo(a-1) + goo(a -2);
    }

    public static int fun(int k){
        if(k==1)
            return 2*k;
        else
            return 2*k + fun(k-1);
    }

    public static int myLife(int a,int b){
        if(b==0)
            return 0;
        if(b%2 == 0)
            return myLife(a+a,b/2);
        return myLife(a+a,b/2)+a;
    }

    public static int sum(int[] d){
        return s(d,d.length-1);
    }

    public static int s(int[] d,int k){
        if( k==0 )
            return d[k];
        return s(d,k-1) + d[k];
    }
}
