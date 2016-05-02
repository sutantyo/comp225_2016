package week7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by daniels on 3/05/2016.
 */
public class DutchFlag {

    public static void main(String[] args){

        int[] data = new int[]{1,3,2,1,1,3,2,2,3,3,3,1,2};
        int size = 13;

        // put 3 at the end (may die horribly if 3 is not in the array)
        for (int i = size-1; i >= 0; i--){
            if (data[i] == 3){
                swap(data,size-1,i);
                break;
            }
        }
        // put 1 at the start of the array (may similarly die horribly)
        for (int i = 0; i < size-1; i++){
            if (data[i] == 1){
                swap(data,0,i);
                break;
            }
        }

        int c = size-1;
        int a = 0;
        int b = 1;
        while (b < c){
            System.out.println(Arrays.toString(data));
            System.out.println("a: " + a + " b: " + b + " c: " + c);
           if (data[b] == 2){
           }
           else if (data[b] > 2){
           }
           else if (data[b] < 2){
           }

        }
    }

    public static void swap(int[] d, int i, int j){
        int temp = d[i];
        d[i] = d[j];
        d[j] = temp;
    }


}
