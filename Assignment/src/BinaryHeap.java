import java.util.NoSuchElementException;

public class BinaryHeap {
    private Object[] elementData;
    private int size;
    public BinaryHeap(int cap){
        elementData = new Object[cap];
    }

    public BinaryHeap(Object[] d){
        elementData = (Object[]) d.clone();
        size = d.length;
        for(int i = size-1; i>=0 ; i--)
            fixDown(i);
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public  Object peek(){
        if(isEmpty()) throw new NoSuchElementException();
        return elementData[0];
    }
    public void enqueue(Object e){
        ensureCapacity(size+1);
        elementData[size] = e;
        fixUp(size++);
    }
    private void fixUp(int k){
        while (k>0){
            int p = (k-1)/2;
            if(!greaterThan(k,p))
                break;
            swap(k,p);
            k = p;
        }
    }
    boolean greaterThan (int i,int j){
        Comparable e = (Comparable) elementData[i];
        return e.compareTo(elementData[j]) > 0;
    }
    void swap(int i,int j){
        Object t = elementData[i];
        elementData[i] = elementData[j];
        elementData[j] = t;
    }
    public Object dequeue(){
        Object max = peek();
        elementData[0] = elementData[--size];
        elementData[size] = null;
        if(size > 1)
            fixDown(0);
        return max;
    }
    private void fixDown(int k){
        int c;
        while ((c = 2 * k + 1) < size){
            if(c + 1 < size && greaterThan(c+1,c))
                c++;
            if(!greaterThan(c,k))
                break;
            swap(k,c);
            k = c;
        }
    }
    private void ensureCapacity(int capacity){
        if(capacity > elementData.length){
            int s = Math.max(capacity,2*elementData.length);
            Object[] arr = new Object[s];
            for(int i=0;i<size;i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }
    public String toString(){
        String s = "[";
        for(int i=0;i<size;i++){
            s = s + elementData[i];
            if(i != size-1)
                s = s + ",";
        }
        return s + "]";
    }
    public int find(Object element){
        Comparable e = (Comparable)element;
        for(int j=0;j<size;j++)
            if(e.compareTo(elementData[j]) == 0)
                return j;
        return -1;
    }
    public void addNew(Object element){
        if(find(element) < 0)
            enqueue(element);
    }
    public Object removeLast(){
        Object e;
        if(size > 0){
            e = elementData[--size];
            elementData[size] = null;
            return e;
        }
        return null;
    }
    public void removeAll(Object element){
        Comparable e = (Comparable) element;
        for(int i=size-1;i>=0;i--) {
            if (e.compareTo(elementData[i]) == 0) {
                if (size > 0)
                    elementData[i] = elementData[size - 1];
                elementData[--size] = null;
                fixDown(i);
            }
        }
    }

    public void removeDataBHeap(Object v){
        if(find(v) == -1) throw new NoSuchElementException();
        Comparable e = (Comparable) v;
        for(int i=size-1;i>=0;i--){
            if(e.compareTo(elementData[i]) == 0){
                if (size > 0)
                    elementData[i] = elementData[size - 1];
                elementData[--size] = null;
                fixDown(i);
                break;
            }
        }
    }
}
