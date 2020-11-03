import java.util.NoSuchElementException;

public class ArrayQueue {
    private Object[] elementData;
    private int size;
    private int front;
    public ArrayQueue (int cap){
        elementData = new Object[cap];
        size = front = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void ensureCapacity() {
        if (size == elementData.length) {
            Object[] arr = new Object[2*elementData.length];
            for(int i = 0,j=front; i < size; i++,j=inc(j))
                arr[i] = elementData[j];
            front = 0;
            elementData = arr;
        }
    }

    private int inc(int i){
        return (i+1) % elementData.length;
    }

    public void enqueue(Object e){
        ensureCapacity();
        int b = (front+size) % elementData.length;
        elementData[b] = e;
        size++;
    }

    public  Object peek(){
        if(isEmpty()) throw new NoSuchElementException();
        return elementData[front];
    }

    public Object dequeue(){
        Object e = peek();
        elementData[front] = null;
        front = inc(front);
        size--;
        return e;
    }

    public String toString( ) {
        String s = "[";
        for( int i=0,j=front; i<size; i++, j=inc(j)  ){
            s = s + elementData[j];
            if( i != (size-1) )
                s = s + ",";
        }
        return s + "]";
    }

    public ArrayQueue(ArrayQueue q){
        elementData = new Object[q.size];
        for(int i=0;i<q.size;i++){
            int k = (q.front+i) % q.elementData.length;
            enqueue(q.elementData[k]);
        }
    }

    public void clear(){
        front = size = 0;
        elementData = new Object[elementData.length];
    }

    public void enqueue2Front(Object e){
        enqueue(e);
        int f = front-1;
        if(f == -1)
            f = elementData.length-1;
        elementData[f] = e;
        if( size != elementData.length )
            elementData[(front + size -1)%elementData.length] = null;
        front = f;
    }

    public boolean equals(ArrayQueue q){
        int m = 0, i = front, j = q.front;
        if(size != q.size)
            return false;
        while (m++ < size){
            if(!elementData[i].equals(q.elementData[j]))
                return false;
            i = (i+1)%elementData.length;
            j = (j+1)%q.elementData.length;
        }
        return true;
    }

    public boolean contains(Object e){
        for(int i=0,j=front ; i<size ; i++){
            if(elementData[j].equals(e))
                return true;
            j = (j+1)%elementData.length;
        }
        return false;
    }

    public void reverseQueue(){
        ArrayQueue temp = new ArrayQueue(elementData.length);
        for(int i=0,j=(front+size)%elementData.length-1;i<size;i++){
            if(!temp.contains(elementData[j])){
                temp.enqueue(elementData[j]);
            }
            j = (j-1)%elementData.length;
        }
        elementData = temp.elementData;
        size = temp.size;
        front = temp.front;
    }

    public void moveToFrontQueue(int idx){
        Object temp = elementData[idx];
        for(int i=idx;i<elementData.length-1;i++){
            elementData[i]=elementData[i+1];
        }
        enqueue2Front(temp);
        size--;
    }

    public Object[] test(int m){
        Object[] a = new Object[0];
        Object[] b = new Object[size];
        if(size == 0)
            return a;
        int i = 0;
        while(i<m && i<b.length){
            b[i] = dequeue();
            //System.out.println(b[i]);
            i++;
        }
        a = new Object[i];
        for(int j=0;j<i;j++){
            a[j] = b[j];
        }
        return a;
    }

    public Object[] frontAndRear(){
        Object[] a = new Object[2];
        if(size == 0)
            return a = new Object[0];
        a[0] = peek();
        a[1] = elementData[(front+size-1)%elementData.length];
        return a;
    }

    public Object getK(int k){
        if (k >= size)
            return null;
        return elementData[(front+size-1-k)%elementData.length];

    }
}
