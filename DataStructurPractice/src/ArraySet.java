public class ArraySet extends ArrayCollection{
    private Object elementData[];
    private int size;
    public ArraySet(){
        size = 0;
        elementData = new Object[100];
        elementData[0] = "a";
        elementData[1] = "b";
    }
    public void add(Object e){
        if(e == null) throw new IllegalArgumentException();
        ensureCapacity(size+1);
        if(!this.contain(e)) {
            elementData[size++] = e;
            System.out.println(e);
        }
    }

    private void ensureCapacity(int cap){
        if(cap > elementData.length){
            int s = Math.max(cap,2*elementData.length);
            Object[] arr = new Object[s];
            for(int i=0;i<size;i++){
                arr[i] = elementData[i];
            }
            elementData = arr;
        }
    }
}
