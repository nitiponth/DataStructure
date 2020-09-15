public class ArrayCollection implements Collection {
    private Object[] elementData;
    private int size;
    public ArrayCollection(){
        elementData = new Object[1];
        size = 0;
    }

    @Override
    public void add(Object e) {
        if(e == null) throw new IllegalArgumentException();
        ensureCapacity(size+1);
        elementData[size++] = e;
    }

    public void remove(Object e){
        if (e == null) throw new IllegalArgumentException();
        if(indexOf(e) != -1) {
            elementData[indexOf(e)] = elementData[--size];
            elementData[size] = null;
        }
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(Object e) {
        return size == 0;
    }

    @Override
    public boolean contain(Object e) {
        if(indexOf(e) != -1)
            return true;
        return false;
    }

    private int indexOf(Object e){
        for(int i=0;i<size;i++){
            if (elementData[i].equals(e))
                return i;
        }
        return -1;
    }

    private void ensureCapacity(int cap){
        if(elementData.length < cap){
            int s = Math.max(cap,2*elementData.length);
            Object[] arr = new Object[s];
            for(int i=0;i<size;i++){
                arr[i] = elementData[i];
            }
            elementData = arr;
        }
    }

    public String toString(){
        String s = "[";
        for (int i=0;i<size;i++){
            if(i < size-1)
                s = s + elementData[i] + ",";
            else
                s = s + elementData[i];
        }
        return s + "]";
    }
}
