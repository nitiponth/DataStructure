public class SinglyLinkedList {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }
    LinkedNode header = new LinkedNode(null, null);
    int size;
    
    public SinglyLinkedList() { }
    public boolean isEmpty() {
        return header.next == null;
    }
    public int size() {
        return size;
    }
    public int indexOf(Object e) {
        LinkedNode q = header.next;
        for (int i=0; i<size; i++) {
            if (q.element.equals(e)) return i;
            q = q.next;
        }
        return -1;
    }   
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void add(int i, Object e) {
        LinkedNode p = nodeAt(i-1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }
    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }
    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e))
            p = p.next;
        removeAfter(p);
    }
    public void remove(int i) {
        LinkedNode p = nodeAt(i-1);
        removeAfter(p);
    }
    public Object get(int i) {
        return nodeAt(i).element;
    }
    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }
    @Override
    public String toString() {
        String out = "<";
        LinkedNode p = header.next;
        while(p != null){
            out = out + p.element;
            if( p.next != null)
                out = out + ",";
            p = p.next;
        }
        return out + ">";
    }
    public void clear( ) {
        header.next = null;
        size = 0;
    }
    public boolean equals(SinglyLinkedList x) {
        LinkedNode q = header.next;
        LinkedNode p = x.header.next;
        while (q != null && p != null) {
            if (!q.element.equals(p.element))
                return false;
            q = q.next;
            p = p.next;
        }
        if(q == null && p == null)
            return true;
        return false ;
    }
}

