public class ArrayList{
    private Object[] elementData;
    private int size;
    public ArrayList(int cap){
        elementData = new Object[cap];
        size = 0;
    }
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
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
        if (i >= 0) remove(i);
    }
    public void remove(int index){
        for(int i=index+1; i<size; i++){
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
    }
    public void add(Object e) {
        if(e == null) throw new IllegalArgumentException();
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }
    
    public void add(int index,Object e) {
        ensureCapacity(size + 1);
        for(int i=size;i>index;i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        size++;
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
        String s = "<";
        for( int i=0; i<size; i++ ){
            s = s + elementData[i];
            if( i != size-1 )
                s = s + ",";
        }
        return s + ">";
    }

    public Object get(int index){
        return elementData[index];
    }
    
    public void set(int index,Object e){
        elementData[index] = e;
    }
    
    public void removeRange(int indexLeft,int indexRight){
        
        if(indexLeft < 0 || indexLeft > indexRight || indexRight > size )
            throw new IllegalArgumentException();
        
        int i;
        int j = indexLeft;
        
        for(i=indexRight;i<size;i++){
            elementData[j] = elementData[i];
            j++;
        }
        for( ; j<size;j++){
            elementData[j] = null;
        }
        size -= (indexRight-indexLeft);
    }
}
