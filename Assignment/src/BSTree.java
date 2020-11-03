import java.security.PublicKey;

public class BSTree extends BinaryTree {
    int size;
    public BSTree(){

    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    int compare(Object a, Object b){
        return ((Comparable)a).compareTo(b);
    }
    public Object get(Object e){
        Node node = getNode(root, e);
        return node == null ? null : node.element;
    }
    Node getNode(Node r, Object e){
        while (r != null){
            int cmp = compare(e,r.element);
            if(cmp == 0)
                return r;
            if(cmp < 0)
                return getNode(r.left, e);
            else
                return getNode(r.right, e);
        }
        return null;
    }

    public Object getMin(){
        Node r = root;
        if(r == null)
            return null;
        while (r.left != null){
            r = r.left;
        }
        return r.element;
    }

    public Object getMax(){
        Node r = root;
        if(r == null)
            return null;
        while (r.right != null){
            r = r.right;
        }
        return r.element;
    }

    public void add(Object e){
        Node newNode = new Node(e,null,null);
        if(root == null)
            root = newNode;
        else {
            Node p = null, r = root;
            while (r != null){
                int cmp = compare(e,r.element);
                if(cmp < 0){
                    p = r;
                    r = r.left;
                }
                else if(cmp > 0){
                    p = r;
                    r = r.right;
                }
                else
                    return;
            }
            if (compare(e, p.element) < 0)
                p.left = newNode;
            else
                p.right = newNode;
        }
        ++size;
    }

    public void remove(Object e){
        root = remove(root, e);
    }

    Node remove(Node r, Object e){
        if(r == null)
            return r;
        int cmp = compare(e, r.element);
        if (cmp < 0){
            r.left = remove(r.left, e);
        }
        else if(cmp > 0){
            r.right = remove(r.right, e);
        }
        else{
            if(r.left == null || r.right == null){
                r = (r.left == null ? r.right : r.left);
                --size;
            }
            else {
                Node m = r.right;
                while (m.left != null)
                    m = m.left;
                r.element = m.element;
                r.right = remove(r.right, m.element);
            }
        }
        return r;
    }

    public static void treeSort(final Object[] data){
        BSTree t = new BSTree();
        for(int i=0; i<data.length;i++){
            t.add(data[i]);
        }
        t.inOrder(new Visitor() {
            int k = 0;
            public void visit(Object e) {
                data[k++] = e;
            }
        });
    }

    public int sum(){
        Object[] arr = toArray();
        int sum = 0;
        for(int i=0;i<size;i++)
            sum += (int)arr[i];
        return sum;
    }

    public int count(Object e){
        Object[] arr = toArray();
        int count = 0;
        for (int i=0;i<size;i++){
            if((int)arr[i] > (int) e)
                count++;
        }
        return count;
    }
}
0