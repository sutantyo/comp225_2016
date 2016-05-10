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
* It's very important that you give Q3 and Q6 a try. Q6 is *very* short, but makes sure that you can play around priority queues.
* By experimentation, we worked out that Iterator on a priority queue doesn't traverse the priority queue in order.
