public class LinkedCollection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
    LinkedNode first;
    int size;  
    public LinkedCollection() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object e) {
        first = new LinkedNode(e, first);
        ++size;
    }
    public boolean contains(Object e) {
        LinkedNode node = first;
        while( node != null ) {
            if (node.element.equals(e)) return true;
                node = node.next;
        }
        return false;   
    }
    public void remove(Object e) {
        if (first == null) return;
        if (first.element.equals(e)) {
            first = first.next; --size;
        } else {
                    LinkedNode p = first;
                    while( p.next != null && ! p.next.element.equals(e)) {
                        p = p.next;
                    }
                    if (p.next != null) {
                        p.next = p.next.next; --size;
                    }
                }
    }
    @Override
    public String toString( ) {
        String s = "[";
        LinkedNode node = first;
        while( node != null ) {
            s = s + node.element;
            if( node.next != null )
               s = s + ",";
            node = node.next;
        }
        return  s + "]";
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = first;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }
//c = [C,B,A] และ d = [B,B,A] เมื่อเรียก v = c. xDiff(d); 
//จะได้ v = [C]
//c = [C,B,A] และ d = [F,B,S] เมื่อเรียก v = c. xDiff(d); 
//จะได้ v = [S,F,A,C]
//c = [C,B,A] และ d = [F,B,C] เมื่อเรียก v = c. xDiff(d); 
//จะได้ v = [F,A]
//c = [A,A,A] และ d = [A,B,B] เมื่อเรียก v = c. xDiff(d); 
//จะได้ v = [B,B]
//c = [A,A,A] และ d = [A,A] เมื่อเรียก v = c. xDiff(d); 
//จะได้ v = [ ]
    public LinkedCollection xDiff(LinkedCollection you){
        LinkedCollection diff = new LinkedCollection();
        LinkedNode p = first;
        while(p != null){
            if(!you.contains(p.element))
                diff.add(p.element);
            p=p.next;
        }
        p = you.first;
        while(p != null){
            if(!this.contains(p.element))
                diff.add(p.element);
            p=p.next;
        }
        return diff;
    }
}