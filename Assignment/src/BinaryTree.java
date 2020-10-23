public class BinaryTree {
    static class Node{
        Object element;
        Node parent;
        Node left;
        Node right;
        Node(Object e, Node l, Node r){
            element = e;
            left = l;
            right = r;
        }
        boolean isLeaf(){
            return  left==null && right==null;
        }
    }

    Node root;

    public int numNode(){
        return numNode(root);
    }
    public int height(){
        return height(root);
    }
    private int numNode(Node node){
        if(node == null)
            return 0;
        return 1 + numNode(node.left) + numNode(node.right);
    }
    private int height(Node node){
        if (node == null)
            return -1;
        return 1 + height(node.left) + height(node.right);
    }

    Node copy(Node r){
        if(r == null)
            return null;
        Node leftTree = copy(r.left);
        Node rightTree = copy(r.right);
        return new Node(r.element, leftTree, rightTree);
    }

    void preOrder(Node r,Visitor v){
        if(r == null || v.isDone())
            return;
        v.visit(r.element);
        preOrder(r.left, v);
        preOrder(r.right, v);
    }

    void inOrder(Node r,Visitor v){
        if(r == null || v.isDone())
            return;
        preOrder(r.left, v);
        v.visit(r.element);
        preOrder(r.right, v);
    }

    void postOrder(Node r,Visitor v){
        if(r == null || v.isDone())
            return;
        preOrder(r.left, v);
        preOrder(r.right, v);
        v.visit(r.element);
    }

    public Object[] toArray(){
        final Object[] a = new Object[numNode()];
        Visitor v = new Visitor() {
            int k = 0;
            public void visit(Object e) {
                a[k++] = e;
            }
        };
        preOrder(root, v);
        return a;
    }

    public boolean contains(final Object x){
        Visitor v = new Visitor() {
            @Override
            public void visit(Object e) {
                if(e.equals(x))
                    done();
            }
        };
        preOrder(root, v);
        return v.isDone();
    }

    public void preOrder(Visitor v){
        preOrder(root, v);
    }
    public void inOrder(Visitor v){
        inOrder(root, v);
    }
    public void postOrder(Visitor v){
        postOrder(root, v);
    }

}