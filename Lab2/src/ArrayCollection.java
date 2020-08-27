//Lab2 Assignment
//Nitipon Thoophom 6203051613034 EnET

public class ArrayCollection {
    private Object[] elementData;
    private int      size;
    public ArrayCollection(int c) {
        elementData = new Object[c];
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private int indexOf(Object e) {
        for (int i=0; i<size; i++)
            if (elementData[i].equals(e)) return i;
        return -1;
    }
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }
    public void remove(Object e) {
        int i = indexOf(e);
        if (i != -1) {
            elementData[i] = elementData[--size];
            elementData[size] = null;
        }
    }
    public void add(Object e) {
        if(e == null) throw new IllegalArgumentException();
        ensureCapacity(size + 1);
        elementData[size++] = e;
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
    @Override
    public String toString( ) {
        String s = "[";
        for( int i=0; i<size; i++ ){
            s = s + elementData[i];
            if( i != size-1 )
                s = s + ",";
        }
        return s + "]";
    }

    public int count(Object e){
        int c = 0;
        for(int i=0;i<size;i++) {
            if (this.elementData[i].equals(e))
                c++;
        }
         return c;
    }

    public boolean containsDup(){
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++)
                if(elementData[i].equals(elementData[j]))
                    return true;
        }
        return false;
    }

    public void clear(){
        for(int i=0;i<size;i++)
            elementData[i] = null;
        size = 0;
    }

    public void removeAll(Object e){
        for(int i=0;i<size;i++)
            if(elementData[i].equals(e)){
                elementData[i] = elementData[--size];
                elementData[size] = null;
            }
    }

    public void addAll(ArrayCollection c){
        for(int i=0;i<c.size;i++)
            this.add(c.elementData[i]);
    }

    public int countUnique(){
        ArrayCollection countAC = new ArrayCollection(0);
        for (int i=0;i<this.size;i++){
            if(!countAC.contains(this.elementData[i]))
                countAC.add(this.elementData[i]);
        }
        return countAC.size;
    }

}

