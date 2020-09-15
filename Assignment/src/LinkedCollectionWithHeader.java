public class LinkedCollectionWithHeader {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
    LinkedNode header = new LinkedNode(null, null);
    int size;
  
    public LinkedCollectionWithHeader() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object e) {
        header.next = new LinkedNode(e, header.next);
        ++size;
    }
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while( node != null ) {
            if (node.element.equals(e)) return true;
                node = node.next;
        }
        return false;   
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while( p.next != null && ! p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next; --size;
        }
    }
    public String toString( ) {
        String s = "[";
        LinkedNode node = header.next;
        while( node != null ) {
            s = s + node.element;
            if( node.next != null )
                s = s + ",";
            node = node.next;
        }
        return  s + "]";
    }
    public Object[] toArray() {
    	Object[] a = new Object[size];
        LinkedNode node = header.next;
        int index = 0;
        while (node != null){
            a[index++] = node.element;
            node = node.next;
        }
   	    return a;
    }
    public LinkedCollectionWithHeader(LinkedCollectionWithHeader c) {
        LinkedNode node = c.header.next;
        while (node != null){
            add(node.element);
            node = node.next;
        }
    }
    

}