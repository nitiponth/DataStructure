public class Main {
    public static void main(String[] args) {
        /*
        ArrayCollection a = new ArrayCollection(5);
        a.add("A");
        a.add("A");
        a.add("C");
        a.add("B");
        a.add("C");

        ArrayCollection c = new ArrayCollection(2);
        c.add("D");
        c.add("C");

        System.out.println(a.toString());
        System.out.println(c.toString());
        a.addAll(c);
        System.out.println(a.toString());
        System.out.println(c.toString());
         */
        /*
        ArrayCollection og = new ArrayCollection(7);
        og.add("A");
        og.add("A");
        og.add("A");
        og.add("A");
        og.add("A");
        og.add("A");
        og.add("A");
        System.out.println(og.toString());
        System.out.println("Unique element in ArrayCollection =: " + og.countUnique());
         */

        P1 p = new P1();
        int[][] array = {{2,5,6,7},{5,200,7,1},{11,12,999,0},{7,11,21,3}};
        //System.out.println(p.sumOfColumn(array,4));
        System.out.println(p.rowOfMax(array));
    }
}
