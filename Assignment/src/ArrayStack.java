import java.util.NoSuchElementException;

public class ArrayStack {
    private Object[] elementData = new Object[100];
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void push(Object e){
        if(size == elementData.length){
            Object[] a = new Object[2*size];
            for(int i=0; i<size; i++)
                a[i] = elementData[i];
            elementData = a;
        }
        elementData[size++] = e;
    }

    public Object peek(){
        if(isEmpty())
            throw new NoSuchElementException();
        return elementData[size-1];
    }

    public Object pop(){
        Object e = peek();
        elementData[--size] = null;
        return e;
    }

    public void reverseStacK(){
        ArrayStack newStack = new ArrayStack();
        while (true){
            if(isEmpty()) break;

            boolean check = true;

            for (int j=0;j<newStack.size;j++){
                if (newStack.elementData[j].equals(peek())) {
                    check = false;
                    pop();
                    break;
                }
            }
            if (check)
                newStack.push(this.pop());
        }

        elementData = newStack.elementData;
        size = newStack.size;

    }

    public void moveToTopOfStack(int idx){
        ArrayStack newStack = new ArrayStack();
        Object temp;
        for (int i=0;i<idx;i++){
            newStack.push(pop());
        }
        temp = pop();
        while (!isEmpty()){
            newStack.push(pop());
        }
       while(!newStack.isEmpty())
            push(newStack.pop());
        push(temp);
    }

    public String toString(){
        String s = "[";
        for( int i=0; i<this.size; i++ ){
            s = s + elementData[i];
            if( i != size-1 )
                s = s + ",";
        }
        return s + "]";
    }
}
