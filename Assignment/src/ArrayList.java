//Nitipon Thoophom
//6203051613034

public class ArrayList {
    Object[] elementData;
    int size;
    public ArrayList(int cap) {
        elementData = new Object[cap];
        size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void remove(Object e) {
        int i = indexOf(e);
        if (i >= 0) remove(i);
    }
    public int indexOf(Object e) {
        for(int i=0; i<size; i++)
            if (elementData[i].equals(e)) return i;
        return -1;
    }
    public Object get(int index) {
        return elementData[index];
    }
    public void set(int index, Object e) {
        elementData[index] = e;
    }
    public void add(int index, Object e) {
        ensureCapacity(size+1);
        for(int i=size; i>index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        size++;
    }
    public void remove(int index) {
        for(int i=index+1; i<size; i++) {
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
    }
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr = new Object[s];
            for(int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i=0; i<size; i++) 
            a[i] = elementData[i];
        return a;
    }
    public String toString( ) {
        String s = "<";
        for( int i=0; i<size; i++ ){
            s = s + elementData[i];
            if( i != size-1 )
            s = s + ",";
        }
        return s + ">";
    }
    public void reverse() {
        for (int i=0;i<size/2;i++){
            Object t = elementData[i];
            elementData[i] = elementData[size-1-i];
            elementData[size-1-i] = t;
        }
        
    }  
    public void addInBound(int i, Object e) {
        if(i<0 || i > size - 1) throw  new IllegalArgumentException();
        ensureCapacity(size+1);
        for(int k=size;k>=i;k--){
            elementData[k] = elementData[k-1];
        }
        elementData[i] = e;
        size++;
    }  
    public void addAll(ArrayList x) {
        for(int i=0;i<x.size;i++){
            add(x.elementData[i]);
        }
    }  
    public void removeRange( int from, int to ) {	
        for(int i=to-1;i>=from;i--){
            remove(i);
        }
    }  
    public void addRange( ArrayList  other, int from ) {
        if(from > size || from < 0) throw new IllegalArgumentException();
        ensureCapacity(size+(other.size));
        for(int i=from;i<(from+other.size);i++){
            add(i,other.elementData[i-from]);
        }
    }
}