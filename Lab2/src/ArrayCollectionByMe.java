public class ArrayCollectionByMe {
    private Object[] elementData;
    private int size;

    public ArrayCollectionByMe(){
        elementData = new Object[100];
        size = 0;
    }

    public ArrayCollectionByMe(int cap){
        elementData = new Object[cap];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void ensureCapacity(int cap){
        if(cap > elementData.length) {
            int newSize = Math.max(cap, 2 * elementData.length);
            Object[] arr = new Object[newSize];
            for(int i=0;i<size;i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }

    public void add(Object e){
        if(e == null)
            throw new IllegalArgumentException();
        ensureCapacity(size+1);
        elementData[size++] = e;
    }

    public void add(int index,Object e){
        if(e == null || index > size)
            throw new IllegalArgumentException();
        ensureCapacity(size+1);
        for (int i=size;i>index;i--)
            elementData[i] = elementData[i-1];
        elementData[index] = e;
        size++;
    }



    public int indexOf(Object e){
        if(e == null)
            throw new IllegalArgumentException();
        for(int i=0;i<size;i++){
            if(e.equals(elementData[i]))
                return i;
        }
        return -1;
    }

    public boolean contains(Object e){
        if(e == null)
            throw new IllegalArgumentException();
        return indexOf(e) != -1;
    }

    public void remove(Object e){
        int index = indexOf(e);
        if (index != -1) {
            elementData[index] = elementData[--size];
            elementData[size] = null;
        }
    }

    public void remove(int index){
        if (elementData[index] != null){
            for (int i=index;i<size;i++)
                elementData[i] = elementData[i+1];
            elementData[size--] = null;
        }
    }

    public Object get(int index){
        if(index >= size || index < 0)
            throw new IllegalArgumentException();
        return elementData[index];
    }

    public void set(int index,Object e){
        if(index >= size || index < 0 || e == null)
            throw new IllegalArgumentException();
        elementData[index] = e;
    }

    @Override
    public String toString(){
        String s = "[";
        for (int i=0;i<size;i++){
            s += elementData[i];
            if (i != size-1)
                s += ",";
        }
        s += "]";
        return s;
    }
}
