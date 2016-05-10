package week8;

/**
 * Created by daniels on 9/05/2016.
 */
public class Q5 {

    public static void main(String[] args){
        int[] a1 = {15, 14, 9, 10, 12, 5};
        System.out.println("a: " + isHeap(a1));
        int[] a2 = {15, 9, 14, 10, 12, 5};
        System.out.println("a: " + isHeap(a2));
        int[] a3 = {15, 14, 9, 10, 5, 12};
        System.out.println("a: " + isHeap(a3));
        int[] a4 = {15};
        System.out.println("a: " + isHeap(a4));
    }

    private static boolean isHeap (int a[]){

        for (int i = a.length-1; i > 0; i--){
            if (a[i] > a[(i-1)/2])
                return false;
        }
        return true;
    }

}
