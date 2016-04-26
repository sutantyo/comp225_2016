# Comp225 Tutorial Notes, i.e. what were discussed in clas

## Week 6 (Binary Search Tree)

* The code for linked list, binary trees, and graphs have a similar structure:
  * linked list: Node next
  * binary tree: Node left, Node right
  * graph: ArrayList<Node> (maybe!)
* Efficiency of data structures: binary tree vs linked list vs array (ArrayList)
  * remember that if you use an array, you may have to shift everything when inserting a new element (at a sorted position)
  * in binary tree, removing or adding is just O(1), once you've found it (taking O(log n) )
  * [nice summary here](http://bigocheatsheet.com/)
* BFS (queue), DFS (stack), Inorder, Preorder (me first!), Postorder (me last!)
* Invariants (will add more later)
