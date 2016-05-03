package week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by daniels on 3/05/2016.
 */
public class FindMedian {

    public static void main (String[] args){

        PriorityQueue<Integer> smaller = new PriorityQueue<>();
        PriorityQueue<Integer> bigger = new PriorityQueue<>();

        Integer[] input = new Integer[]{3,4,8,1,2,9,14,7,6,16,10};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(input));

        Integer median = list.get(0);
        for (int i = 1; i < list.size(); i++){
           if (list.get(i) > median){
               bigger.add(list.get(i));
           }
            else if (list.get(i) < median){
               smaller.add(-list.get(i));
           }
            // rebalance
            if (smaller.size() > bigger.size() + 1){
                bigger.add(-median);
                median = -smaller.poll();
            }
            else if (bigger.size() > smaller.size() + 1){
                smaller.add(median);
                median = bigger.poll();
            }
        }

        System.out.println("Median is " + median);

    }
}
