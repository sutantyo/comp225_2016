package week6;
/************************  IntBSTNode.java  **************************/

public class IntBSTNode {

    protected int key;
    protected IntBSTNode left, right;

    public IntBSTNode() {
        left = right = null;
    }
    public IntBSTNode(int el) {
        this(el,null,null);
    }
    public IntBSTNode(int el, IntBSTNode lt, IntBSTNode rt) {
        key = el; left = lt; right = rt;
    }
    public void visit() {
        System.out.print(key + " ");
    }
    public String toString() {
        return "" + key;
    }
}