# Comp225 Tutorial Notes

Here are my personal notes for the stuffs that we did in the class. 

## Week 6 (Binary Search Tree)

* The code for linked list, binary trees, and graphs have a similar structure:
  * linked list: Node next
  * binary tree: Node left, Node right
  * graph: ArrayList&ltNode&gt (maybe!)
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

## Week 7 (Sorting)

* Insertion sort, selection sort, merge sort, bucket/radix sort, and even quick sort is all natural to you, even though it
maybe be strange at start. It should be easy to remember how these algorithm work. Shell sort is the only one which is unnatural.
* Every time you are asked to provide a numerical answer, BACK IT UP. Give the formula behind your answer, or give a reason why.
This way, even if your answer is wrong, you will still get partial mark if your reasoning is correct.
* For Q1(d) part i), we worked out the explicit formula for the number of comparisons in shell sort, because it's a 5-sort followed
by a 1-sort. If there was a 3-sort in the middle, we lose the structure of the array.
* Q2 -> How you store your data depends on how you're going to use your data!
* Q3 -> For part (c), there is a binary-search-like algorithm. Give it a try. It is a divide-and-conquer strategy.
* Q4 -> Sorting is great, but don't blindly sort everything! Sometimes it doesn't make any difference whether you sort the data first or not.
Other times, it makes a huge difference. Read each case again and convince yourself whether or not you would sort.
* Complexity analysis: just because something is O(n), doesn't mean it is always better than an O(n^2) algorithm. Imagine if you have
an algorithm which requires 5000n operations, vs an algorithm that requires 3n^2 operations. If your n is very big, then the O(n)
algorithm is better. However, in many real life application, sometimes it's just faster to use the slower algorithm when n is small.
The faster algorithm may also require more work to set up. For example, complexity of n + 1000 = O(n) (look up precomputation on wikipedia).
* DO THE QUICKSORT QUESTION. TRACE THE ALGORITHM. IT WILL BE IN THE EXAM! (or at least something similar to it will be).
* Q7 and Q8 are different variations of quicksort: same concept, different application. Look at DutchFlag.java in src/week7, and complete it for Q8.
You only need to add 3 lines.
* Added FindMedian.java that can be used to find the median in one pass, but since it uses two priority queues, it is still O(n log n).

## Week 8 (Heap)

* The notes are a bit short this week because we didn't discuss too many things. It's a good tutorial for you to try on your own!
* What is the difference between a PriorityQueue and a Heap? Remember that a priority queue can be implemented in many ways (arrays, binary search tree,
linked list, and of course, heaps)
* Q1-Q2: the idea is to use a priority queue to get the n-th element in an array (implicitly sorting the array)
* Q3: make sure you know how to do heapDelete() and heapInsert(int), and can trace it by hand. The final answer is 6,4,5,1,2,3
* Q6: int c - int 'a' is the offset that you need. It will set 'a' to 0, 'b' to 1, etc, which the index of the array containing the priority queue
that you need
* Q7: The use of comparator. You can find my version of comparator implementation in Q7.java. Remember that the method compare(a,b) should return a positive
value if a > b and negative value when a < b.
* It's very important that you give Q3 and Q6 a try. Q6 is *very* short, but it is good in making sure that you can use priority queues.
* By experimentation, we worked out that Iterator on a priority queue doesn't traverse the priority queue in order. I believe it prints out the array
in sequence. Give it a try!

## Week 9 (Hash Tables)

* Make sure you do the coding exercises. This tutorial and the coming ones are becoming more  practical and you should attempt it yourself rather than
just looking at the solution. Ask me if you have any problems.
* Make sure you understand why we are doing hashing, read the example in the lecture notes about indexing students by their student numbers.
* For the codes involving linear probing and quadratic probing, make sure you handle the case when the array is full, otherwise you
may run into an infinite loop.
* There is a mistake in the code that I put up: on deletion or find, you shouldn't stop at -1; you should stop only when you find the key
or you hit a 0.
* For quadratic probing, it is useful to precompute the indices that you will try to use, i.e. 0,-1,1,4,-4,9,-9,... . If you were to
compute these as you insert/find/delete, the code will be quite complicated. Plus, it is just much more efficient to do this once at the start
and then do a table lookup every time you need to do an insertion/find/deletion.
* Converting an array into a heap is O(n log n), heapRebuild is O(log n), hence heapsort is O(n log n). Make sure you understand why.
Make sure you know how to trace a heapsort (when and where to call heapRebuild()).
* Using heapsort to do a sort in descending order is O(n^2 log n), because with the way I showed in class, you have to convert the array
into a heap at every iteration, and this costs O(n log n) (and you have to do it n times)

## Week 10 (Simple Graphs)

* We went through the code in the tutorial class, reinforcing what you have learnt in class. Note that if you understand
the codes for this week, it is almost identical to the pass component of your second assignment, so give them a very
good read!
* These are the terms/definitions that you need to know when it comes to graphs: vertices/nodes (and their degrees),
edges (and their weights), acyclic/cyclic (a tree is acyclic graph), directed/undirected (digraph), connected/unconnected,
adjacency list, adjacency matrix, DFS, BFS, bipartite, unipartite.
* DFS traversal can be done using a stack, so it is also natural to do it using recursion because you are implicitly using
a stack (the method call stack).
* BFS traversal can be done using a queue. Don't try to do BFS recursively, brain explosion can be messy.
* In both DFS and BFS, the last node that you visit is the last node that you add to the stack or queue, respectively, so
finding out this last node is quite trivial using the iterative version. The recursive version is slightly harder because
you have to think about the base case.
* Q5 is the hardest question in the whole tutorial, but can be done quite easily using the iterative version by looking
at the size of the stack. For a good exercise, using the iterative DFS code, see if you can return the longest chain
instead of just returning its length.
* I did not put any code from this week's tutorial, but inside week10/src, you will see a maze folder which contains the
JavaFX animation that I did in class for BFS/DFS. Game.java is the class that contains the logic (DFS and BFS).

## Week 11 (More graphs)

* Euler Circuit and Euler Path; the algorithm to determine if one exists is
very simple: just check the degrees of the nodes. You can do this via DFS
or just go through each node. Start with this code:
```java
	public boolean hasEulerPath() {
		Integer tmp = numVerticesEvenDeg(this.getFirstVertexID());
		return ((tmp == this.numVertices()) || (tmp == (this.numVertices()-2)));
	}
```
* Topological ordering may not be unique. You can create a topological sort
by picking nodes with no ancestors first, or picking nodes with no successors
first.
* Q5, the topSortEarlyW(..) code is wrong since it does topsort by picking
nodes with no successors first. So in fact W will be printed out later.
* Q6 illustrates that both DFS (and BFS) can both make a spanning tree,
though not necessarily the minimum one. Each vertex will only be accessed
once, so only n-1 edges will be added in a graph of size n
* Dijkstra's algorithm: make sure you can trace through it. It will not
work with negative values. Note that you can have a path with negative infinity!