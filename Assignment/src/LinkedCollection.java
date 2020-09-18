//Nitipon Thoophom
//6203051613034

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
    public int count(Object e) {
        if(e == null) throw new IllegalArgumentException();
        int count = 0;
    	LinkedNode p = first;
    	while (p != null){
    	    if(p.element.equals(e))
    	        count++;
    	    p = p.next;
        }
        return count;
    }

    public Object getDup( ) {
        if(first == null) return null;
        LinkedNode p = first;
        while (p != null){
            LinkedNode q = p.next;
            while (q != null){
                if(p.element.equals(q.element))
                    return q.element;
                q = q.next;
            }
            p = p.next;
        }
        return null;
    }  
    public void clear( ) {
    	size = 0;
    	first = null;
    }
}