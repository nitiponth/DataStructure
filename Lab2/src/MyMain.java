public class MyMain {
    public static void main(String[] args) {
        ArrayCollectionByMe ac = new ArrayCollectionByMe(100);
        ac.add("A");
        ac.add("B");
        ac.add("C");
        ac.add("D");
        ac.add(2,"E");
        ac.remove(4);

        System.out.println(ac.toString());
        System.out.println(ac.size());
        System.out.println(ac.get(0));
        ac.set(-1,"Z");
        System.out.println(ac.toString());

    }
}
