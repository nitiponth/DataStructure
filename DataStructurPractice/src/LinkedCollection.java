public class LinkedCollection implements Collection {
    private  static class LinkedNode{
        private Object element;
        private LinkedNode next;
        LinkedNode(Object e,LinkedNode n){
            this.element = e;
            this.next = n;
        }
    }
    private int size;
    private LinkedNode first;

    public LinkedCollection(){
        size = 0;
        first = null;
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(Object e) {
        return false;
    }

    public void add(Object e){
        if(e == null) throw new IllegalArgumentException();
        first = new LinkedNode(e,first);
        size++;
    }

    public boolean contain(Object e){
        if(e == null) throw new IllegalArgumentException();
        LinkedNode p = first;
        while (p != null && !p.element.equals(e))
            p = p.next;
        return p != null;
    }

    public void remove(Object e){
        if(e == null) throw new IllegalArgumentException();
        if(first == null) return;
        if(first.element.equals(e)){
            first = first.next;
            size--;
        }
        LinkedNode p = first;
        while (p.next != null && !p.next.element.equals(e))
            p = p.next;
        if(p.next != null){
            p.next = p.next.next;
            size--;
        }
    }

    public String toString(){
        String s = "<";
        LinkedNode p = first;
        while(p.next != null){
            if (p.next.next != null) {
                s = s + p.next.element + ",";
                p = p.next;
            }
            s = s + p.next.element;
        }
        return s + ">";
    }
}
