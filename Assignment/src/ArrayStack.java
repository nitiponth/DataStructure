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

    public int multiPop(int k){
        int sum=0;
        for (int i=size-1;i>=0;i--){
            if(((int)elementData[i] + sum) < k)
                sum += (int)pop();
        }
        return sum;
    }

    public Object[] multiPopE(int k,Object e){
        Object[] a = new Object[0];
        Object[] b = new Object[size];
        if(size == 0)
            return a;
        int i = 0;
        while (i<k && !isEmpty()){
            b[i++] = pop();
            if(isEmpty())
                break;
            else if (e.equals(peek())) {
                b[i++] = pop();
                break;
            }
        }

        a = new Object[i];
        for(int j=0;j<i;j++){
            a[j] = b[j];
        }
        return a;
    }

    public void setReverse(ArrayStack s){
        if(s.isEmpty())
            return;
        ArrayStack temp = new ArrayStack();
        for (int i=0;i<size;i++)
            temp.elementData[i] = s.elementData[i];
        elementData = new Object[1];
        temp.size = s.size; size=0;
        while(!temp.isEmpty())
            push(temp.pop());

    }
}
