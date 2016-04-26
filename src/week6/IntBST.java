package week6;
import org.junit.Test;
import static org.junit.Assert.*;

/************************  IntBST.java  **************************/

public class IntBST {

    protected IntBSTNode root;
    int number= 0;

    protected void visit(IntBSTNode p) { // Visit just print out the key

        System.out.print(p.key + " ");
    }

    // constructor
    public IntBST() {

        root = null;
    }
    public IntBSTNode search(int el) {

        return search(root,el);
    }
    protected IntBSTNode search(IntBSTNode p, int el) {

        while (p != null)
            if (el == p.key)
                 return p;
            else if (el < p.key)
                 p = p.left;
            else p = p.right;
        return null;
    }

public void breadthFirst() {

        IntBSTNode p = root;
        Queue queue = new Queue();
        if (p != null) {
             queue.enqueue(p);
             while (!queue.isEmpty()) {
                 p = (IntBSTNode) queue.dequeue();
                 visit(p);
                 if (p.left != null)
                      queue.enqueue(p.left);
                 if (p.right != null)
                      queue.enqueue(p.right);
             }
        }
    }

public String preorder() {
       return preorder(root);
    }
    protected String preorder(IntBSTNode p) {
        if (p != null) {
             return p.key  + preorder(p.left)  + preorder(p.right);
        }
        else return "";
    }
    public String inorder() {
       return  inorder(root);
    }
    protected String inorder(IntBSTNode p) {
        if (p != null) {
            return inorder(p.left)  + p.key  + inorder(p.right);
        }
        else return "";
    }
    public String postorder() {
        return postorder(root);
    }
    protected String postorder(IntBSTNode p) {
        if (p != null) {
           return  postorder(p.left) + postorder(p.right)  +  p.key;
        }
        else return "";
    }

public void iterativePreorder() {
        IntBSTNode p = root;
        Stack travStack = new Stack();
        if (p != null) {
             travStack.push(p);
             while (!travStack.isEmpty()) {
                 p = (IntBSTNode) travStack.pop();
                 visit(p);
                 if (p.right != null)
                      travStack.push(p.right);
                 if (p.left  != null)        // left child pushed after right
                      travStack.push(p.left);// to be on the top of the stack;
             }
        }
    }

public void iterativeInorder() {
        IntBSTNode p = root;
        Stack travStack = new Stack();
        while (p != null) {
            while(p != null) {               // stack the right child (if any) (1)
                 if (p.right != null)        // and the node itself when going
                	travStack.push(p.right); // to the left;
                 	travStack.push(p);
                 	p = p.left;
            }
            p = (IntBSTNode) travStack.pop();   // pop a node with no left child (2)
            while (!travStack.isEmpty() && p.right == null) { // visit it and all
                 visit(p);                   // nodes with no right child;
                 p = (IntBSTNode) travStack.pop();
            }
            visit(p);                        // visit also the first node with (3)
            if (!travStack.isEmpty())        // a right child (if any);
                 p = (IntBSTNode) travStack.pop();
            else p = null;
        }
    }

public void iterativePostorder() {
        IntBSTNode p = root;
        Stack travStack = new Stack(), output = new Stack();
        if (p != null) {        // left-to-right postorder = right-to-left preorder
             travStack.push(p);
             while (!travStack.isEmpty()) {
                 p = (IntBSTNode) travStack.pop();
                 output.push(p);
                 if (p.left != null)
                      travStack.push(p.left);
                 if (p.right != null)
                      travStack.push(p.right);
             }
             while (!output.isEmpty()) {
                 p = (IntBSTNode) output.pop();
                 visit(p);
             }
        }
    }

public void insert(int el) {
        IntBSTNode p = root, prev = null;
        while (p != null) {  // find a place for inserting new node;
            prev = p;
            if (p.key < el)
                 p = p.right;
            else p = p.left;
        }
        if (root == null)    // tree is empty;
             root = new IntBSTNode(el);
        else if (prev.key < el)
        { prev.right = new IntBSTNode(el); number++;}
        else { prev.left  = new IntBSTNode(el); number++;}
    }
    
    
    public void deleteByCopying(int el) {
        IntBSTNode node, p = root, prev = null;
        while (p != null && p.key != el) {       // find the node p
             prev = p;                            // with element el;
             if (p.key < el)
                  p = p.right;
             else p = p.left;
        }
        node = p;
        if (p != null && p.key == el) {
             if (node.right == null)              // node has no right child;
                  node = node.left;
             else if (node.left == null)          // no left child for node;
                  node = node.right;
             else {
                  IntBSTNode tmp = node.left;     // node has both children;
                  IntBSTNode previous = node;     // 1.
                  while (tmp.right != null) {     // 2. find the rightmost
                      previous = tmp;             //    position in the
                      tmp = tmp.right;            //    left subtree of node;
                  }
                  node.key = tmp.key;             // 3. overwrite the reference  
                  if (previous == node)           //    of the key being deleted;
                       previous.left  = tmp.left; // 4.
                  else previous.right = tmp.left; // 5.
             }
             if (p == root)
                  root = node;
             else if (prev.left == p)
                  prev.left = node;
             else prev.right = node;
           number--;
        }    
        else if (root != null)
             System.out.println("key " + el + " is not in the tree");
        else System.out.println("the tree is empty");
    }
  
    public void clear() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public boolean isInTree(int el) {
        return search(root,el) != null;
    }
    
    public void balance(int data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last)/2;
            System.out.print(data[middle]+" ");
            insert(data[middle]);
            balance(data,first,middle-1);
            balance(data,middle+1,last);
        }
    }

    public boolean hasPathSum(int sum) {
    	return hasPathSum(root, sum);
    }


    public boolean hasPathSum(IntBSTNode p, int sum) {

        if (p == null)
            return false;
        else {
            // the following commented line is incorrect, can you see why?
            // return hasPathSum(p.left,sum-p.key) || hasPathSum(p.right,sum-p.key);

            return hasPathSum(p.left,sum-p.key) || ((sum == p.key) && p.left == null && p.right == null) || hasPathSum(p.right,sum-p.key);
        }
    }

    public int numberOfFullNodes(){
        return numberOfFullNodes(root);
    }

    private int numberOfFullNodes(IntBSTNode p){
       if (p == null)
           return 0;
        else if (p.left != null && p.right != null)
           return 1 + numberOfFullNodes(p.left) + numberOfFullNodes(p.right);
        else
           return numberOfFullNodes(p.left) + numberOfFullNodes(p.right);
    }

    public int sumOfNodes(){
       return sumOfNodes(root);
    }

    /* You can do it like this if you want to, just to contrast with the solution which I commented out.
     * The stopping condition is no longer when (p == null), it's when p's children are both null.
     * You can see how it's more complicated to write it this way */
    private int sumOfNodes(IntBSTNode p){
        if (p.left == null && p.right == null)
            return p.key;
        else if (p.left == null){
            return p.key + sumOfNodes(p.right);
        }
        else if (p.right == null){
            return p.key + sumOfNodes(p.left);
        }
        else{
            return sumOfNodes(p.right) + p.key + sumOfNodes(p.left);
        }

        /* Original solution:

        if (p == null)
            return 0;
        else
            return sumOfNodes(p.right) + p.key + sumOfNodes(p.left);
        */

    }

    public boolean isBalanced(){
        return isBalanced(root) >= 0;
    }
    private int isBalanced(IntBSTNode p){
        /* TO DO !!! */
        return 0;
    }

    @Test
    public   void TestEmptyBST() {
        IntBSTNode p=	search(1);
        assertNull(p);
    }

    @Test
    public  void TestInsert() {
        insert(2);
        insert(3);
        insert(4);
        IntBSTNode p=	search(2);
        assertEquals(2, p.key);
        p=	search(4);
        assertEquals(4, p.key);
        p=	search(5);
        assertNull(p);
    }

    @Test
    public   void TestDelete() {
        insert(5);
        insert(6);
        insert(7);

        IntBSTNode p=	search(7);
        assertEquals(7, p.key);
        deleteByCopying(7);
        p=	search(7);
        assertNull(p);
    }

    @Test
    public  void TestInorder() {

        root= null;
        insert(2);
        insert(3);
        insert(4);
        insert(1);
        insert(6);
        insert(5);

        String A= inorder();
        System.out.println(A);
        assertEquals("123456", A);

    }

    @Test
    public  void TestPreorder() {

        root= null;
        insert(2);
        insert(3);
        insert(4);
        insert(1);
        insert(6);
        insert(5);
        String A= preorder();
        System.out.println(A);
        assertEquals("213465", A);

    }

    @Test
    public  void TestPostorder() {

        root= null;
        insert(2);
        insert(3);
        insert(4);
        insert(1);
        insert(6);
        insert(5);
        String A= postorder();
        System.out.println(A);
        assertEquals("156432", A);

    }

    @Test
    public  void TesthasPathSum(int sum) {

        root= null;
        insert(13);
        insert(10);
        insert(25);
        insert(2);
        insert(12);
        insert(20);
        insert(31);
        insert(29);
        System.out.println(hasPathSum(sum));
        assertEquals(hasPathSum(sum), true);

    }
    
}
