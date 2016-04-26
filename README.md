# Comp225 Tutorial Notes

Here are my personal notes for the stuffs that we did in the class. 

## Week 6 (Binary Search Tree)

* The code for linked list, binary trees, and graphs have a similar structure:
  * linked list: Node next
  * binary tree: Node left, Node right
  * graph: ArrayList<Node> (maybe!)
* Efficiency of data structures: binary tree vs linked list vs array (ArrayList)
  * remember that if you use an array, you may have to shift everything when inserting a new element (at a sorted position)
  * in binary tree, removing or adding is just O(1), once you've found it (taking O(log n) )
  * [nice summary of algorithm complexity here](http://bigocheatsheet.com/)
* BFS (queue), DFS (stack), Inorder, Preorder (me first!), Postorder (me last!)
* Recurrence relations of methods for binary tree. Remember that a node is a tree-with-one-node! If your method works for a tree,
then it should work for a single node.

p.s. I used the word 'invariant' in the 9am class while attempting to illustrate the final point.
I think that's a bad word to use since you are used to loop invariants (which has a precise meaning).
Please don't use this word.
