package week6;

import org.junit.*;
import org.junit.Test;

import week6.IntBST;

import static org.junit.Assert.assertEquals;

/**
 * Created by daniels on 25/04/2016.
 */
public class IntBSTTest {

    public IntBST firstTree;
    public IntBST secondTree;
    public IntBST thirdTree;
    public IntBST fourthTree;
    public IntBST fifthTree;

    @Before
    public void setUp() throws Exception {
        firstTree = new IntBST();
        firstTree.insert(13);
        firstTree.insert(10);
        firstTree.insert(2);
        firstTree.insert(12);
        firstTree.insert(25);
        firstTree.insert(20);
        firstTree.insert(31);
        firstTree.insert(29);

        secondTree = new IntBST();
        secondTree.insert(10);
        secondTree.insert(5);
        secondTree.insert(20);
        secondTree.insert(4);
        secondTree.insert(6);
        secondTree.insert(15);
        secondTree.insert(30);
        secondTree.insert(0);
        secondTree.insert(7);
        secondTree.insert(13);
        secondTree.insert(8);

        thirdTree = new IntBST();
        thirdTree.insert(10);
        thirdTree.insert(5);
        thirdTree.insert(15);
        thirdTree.insert(4);
        thirdTree.insert(3);
        thirdTree.insert(2);

        fifthTree = new IntBST();
        fifthTree.insert(13);
        fifthTree.insert(6);
        fifthTree.insert(20);
        fifthTree.insert(4);
        fifthTree.insert(8);
        fifthTree.insert(15);
        fifthTree.insert(30);
        fifthTree.insert(0);
        fifthTree.insert(5);
        fifthTree.insert(7);
        fifthTree.insert(10);
    }

    @Test
    public void testHasPathSum(){
        assertEquals(firstTree.hasPathSum(58),true);
        assertEquals(firstTree.hasPathSum(150),false);
        assertEquals(firstTree.hasPathSum(23),false);

        assertEquals(secondTree.hasPathSum(190),false);
        assertEquals(secondTree.hasPathSum(20),false);
        assertEquals(secondTree.hasPathSum(19),true);
    }

    @Test
    public void testNumberOfFullNodes(){
        assertEquals(firstTree.numberOfFullNodes(),3);
        assertEquals(secondTree.numberOfFullNodes(),3);
    }

    @Test
    public void testSumOfNodes(){
        assertEquals(firstTree.sumOfNodes(),142);
        assertEquals(secondTree.sumOfNodes(),118);
    }

    /*
    @Test
    public void testIsBalanced(){
        assertEquals(firstTree.isBalanced(),true);
        assertEquals(secondTree.isBalanced(),true);
        assertEquals(thirdTree.isBalanced(),false);
        assertEquals(fifthTree.isBalanced(),true);
    }
    */
}



/*
fourthTree = new IntBST();
        fourthTree.insert(10);
        fourthTree.insert(5);
        fourthTree.insert(4);
        fourthTree.insert(3);
        fourthTree.insert(8);
        fourthTree.insert(17);
        fourthTree.insert(15);
        fourthTree.insert(13);
        fourthTree.insert(18);
       */